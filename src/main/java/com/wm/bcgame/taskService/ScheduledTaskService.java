package com.wm.bcgame.taskService;

import com.google.gson.Gson;
import com.wm.bcgame.base.BaseConstant;
import com.wm.bcgame.dto.CoinKline;
import com.wm.bcgame.dto.CoinSingle;
import com.wm.bcgame.dto.RaiseRank;
import com.wm.bcgame.huobi.api.ApiClient;
import com.wm.bcgame.huobi.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ScheduledTaskService {
	private final Logger logger = LoggerFactory.getLogger(Scheduled.class);
	//	时长对应的毫秒数
	private static final Long MS_5MIN = 300000L;
	private static final Long MS_30MIN = 1800000L;
	private static final Long MS_60MIN = 3600000L;
	private static final Long MS_1DAY = 86400000L;

	private final static String BASE_CURRENCY = "usdt";

	@Value("${huobi.key}")
	private String API_KEY;
	@Value("${huobi.secret}")
	private String API_SECRET;
//	@Autowired
//	RedisTemplate redisTemplate;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	private ApiClient apiClient;

	@Scheduled(fixedRate = 86400000)
	public void currencys() {
		apiClient = new ApiClient(API_KEY, API_SECRET);
		String symbol = "ethusdt";
		CurrencysResponse currencysResponse = apiClient.currencys(symbol);
		logger.info("======currencys====status:{};data:{}", currencysResponse.getStatus(), currencysResponse.getData());
//		写入redis
		if (currencysResponse.getStatus().equals("ok")) {
			String values = currencysResponse.getData().toString();
			values = values.substring(1, values.length() - 1);
			stringRedisTemplate.opsForValue().set(BaseConstant.HUOBI_CURRENCY, values);
		}
	}

	//循环获取单个symbol币种的信息
	@Scheduled(fixedRate = 120000)
	public void getDetail() {
		apiClient = new ApiClient(API_KEY, API_SECRET);
		String val = stringRedisTemplate.opsForValue().get(BaseConstant.HUOBI_CURRENCY).toString();
		ZSetOperations opsForZSet;
		String[] arr = val.split(",");
		Gson gson = new Gson();
		for (String coin : arr) {
			coin = coin.trim();
//			if(coin.equals(BASE_CURRENCY)){
//				continue;
//			}
//    		组合symbol
			String symbol = coin + "usdt";
			try {
				DetailResponse<Details> detailResponse = apiClient.detail(symbol);
				logger.info("==获取币种信息成功==币种:{},返回值:{}", symbol, detailResponse.getTick().toString());
				if (detailResponse != null && detailResponse.getStatus().equals("ok")) {
//				写入redis
					Details details = detailResponse.getTick();
					CoinSingle coinSingle = new CoinSingle();
					coinSingle.setAmount(details.getAmount());
					coinSingle.setClose(details.getClose());
					coinSingle.setCount(details.getCount());
					coinSingle.setHigh(details.getHigh());
					coinSingle.setLow(details.getLow());
					coinSingle.setTs(detailResponse.getTs());
					coinSingle.setVol(details.getVol());
					coinSingle.setOpen(details.getOpen());
					String values = gson.toJson(coinSingle);
					stringRedisTemplate.opsForValue().set(BaseConstant.HUOBI_CURRENCY_DETAIL+symbol,values);
//					统计涨幅
					double raise =  details.getClose() - details.getOpen();
					double raisePercent = raise * 100 / details.getOpen();
//					写入redis的排序
					opsForZSet = stringRedisTemplate.opsForZSet();
					opsForZSet.add(BaseConstant.HUOBI_CURRENCY_RANK,symbol,raisePercent);
				}
			} catch (Exception e) {
				logger.error("======获取币种信息失败======币种:{}======错误信息:{}", symbol, e.getMessage());
			}
		}
	}

//	统计涨幅榜和跌幅榜--10秒
	@Scheduled(fixedRate = 240000)
	public void raiseRank(){
		StringBuilder stringBuilder = new StringBuilder();
		int count = 1 ;
		Gson gson = new Gson();
		List<RaiseRank> raiseRanks = new ArrayList<>();

		ZSetOperations opsForZSet = stringRedisTemplate.opsForZSet();
		Set<String> values = opsForZSet.rangeByScore(BaseConstant.HUOBI_CURRENCY_RANK,0 ,1000);
		for(String value:values){
			String detail = stringRedisTemplate.opsForValue().get(BaseConstant.HUOBI_CURRENCY_DETAIL+value).toString();
			CoinSingle coinSingle = gson.fromJson(detail,CoinSingle.class);
			RaiseRank raiseRank = new RaiseRank();
//			raiseRank.setCoinNo(value);
//			raiseRank.setOpen(coinSingle.getOpen());
//			raiseRank.setClose(coinSingle.getClose());
//			raiseRank.setVol(coinSingle.getVol());
//			raiseRank.setAmount(coinSingle.getAmount());
//			raiseRank.setCount(coinSingle.getCount());
//			raiseRank.setRank(count);
////			收盘价--人民币计价
//			raiseRank.setCloseRmb(coinSingle.getClose());
//			raiseRank.setRate(coinSingle.getClose() - coinSingle.getOpen());

			count ++;
			if(count == 31){
				break;
			}
		}

	}

	//统计日k线图--5min
	@Scheduled(fixedRate = 300000)
	public void kLineDay() {
		getKlines("5min", "288", BaseConstant.HUOBI_CURRENCY_KLINE_DAY);
	}

	//统计周k线图--30min
	@Scheduled(fixedRate = 1800000)
	public void kLineWeek() {
		getKlines("30min", "336", BaseConstant.HUOBI_CURRENCY_KLINE_WEEK);
	}

	//统计月k线图--60min
	@Scheduled(fixedRate = 3600000)
	public void kLineMonth() {
		getKlines("60min", "744", BaseConstant.HUOBI_CURRENCY_KLINE_MONTH);
	}

	//统计年k线图--1day
	@Scheduled(fixedRate = 86400000)
	public void kLineYear() {
		getKlines("1day", "365", BaseConstant.HUOBI_CURRENCY_KLINE_YEAR);
	}


	private void getKlines(String period, String size, String key) {
		apiClient = new ApiClient(API_KEY, API_SECRET);
		Long MS = 0L;
		String msgLog = "";
		switch (period) {
			case "5min":
				MS = MS_5MIN;
				msgLog = "获取币种日k线信息";
				break;
			case "30min":
				MS = MS_30MIN;
				msgLog = "获取币种周k线信息";
				break;
			case "60min":
				MS = MS_60MIN;
				msgLog = "获取币种月k线信息";
				break;
			case "1day":
				MS = MS_1DAY;
				msgLog = "获取币种年k线信息";
				break;
			default:
				MS = MS_5MIN;
		}
		String val = stringRedisTemplate.opsForValue().get(BaseConstant.HUOBI_CURRENCY).toString();
		String[] arr = val.split(",");
		for (String coin : arr) {
			coin = coin.trim();
			String symbol = coin + "usdt";
			try {
				KlineResponse<List<Kline>> klineResponse = apiClient.kline(symbol, period, size);
				logger.info("=={}成功======币种:{},返回值:{}", msgLog, symbol, klineResponse.data.toString());
				if (klineResponse != null && klineResponse.getStatus().equals("ok")) {
//					转换为落地的日k线json数据
					String value = toCoinKlines(klineResponse, MS);
					stringRedisTemplate.opsForValue().set(key + symbol, value);
				}
			} catch (Exception e) {
				logger.error("======{}失败======币种:{}======错误信息:{}", msgLog, symbol, e.getMessage());
			}
		}
	}

	//	转换为  kline的json返回
	private String toCoinKlines(KlineResponse<List<Kline>> klineResponse, Long MS) {
		Gson gson = new Gson();
		Long ts = Long.valueOf(klineResponse.getTs());
		List<Kline> klineList = klineResponse.data;
		List<CoinKline> coinKlines = new ArrayList<>();
//		获取兑换的汇率rmb usdt
		double exchangeRate = Double.valueOf(stringRedisTemplate.opsForValue().get(BaseConstant.EXCHANGE_RATE_RMB_USD));

		for (Kline kline : klineList) {
			CoinKline coinKline = new CoinKline();
			coinKline.setTs(ts);
//			收盘价-最新价（rmb）
			coinKline.setCloseRmb(kline.getClose()*exchangeRate);
//			成交额-24H（rmb）
			coinKline.setVolRmb(kline.getOpen()*exchangeRate);
//			收盘价-最新价（usdt）
			coinKline.setCloseUsdt(kline.getClose());
//			时间增加
			ts = ts - MS;
			coinKlines.add(coinKline);
		}
		return gson.toJson(coinKlines);
	}
}
