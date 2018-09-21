package com.wm.bcgame.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wm.bcgame.base.BaseConstant;
import com.wm.bcgame.dto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LZM
 * @description 获取币种相关信息
 * @date 11:36 2018/9/11
 * @mondified
 **/

@RestController
@RequestMapping("/coinList")
@Api(value = "币种相关", description = "币种相关")
public class CoinController {
	private static final Logger logger = LoggerFactory.getLogger(CoinController.class);

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@ApiOperation(value = "涨幅榜", notes = "获取按涨幅排位的前30位币种信息")
	@ApiImplicitParam(name = "raiseType", value = "涨跌标志 涨幅0/跌幅1", paramType = "query", required = true, dataType = "Integer")
	@RequestMapping(value = "/raiseRank", method =  RequestMethod.POST)
	public List<RaiseRank> raiseRank(@ApiParam Integer raiseType) {

		List<RaiseRank> raiseRanks = new ArrayList<>();
		RaiseRank raiseRank = new RaiseRank();
		raiseRank.setCoinNo("eth");
		raiseRank.setRate(12.2D);
		raiseRank.setCloseRmb(11.3D);
		raiseRank.setCloseUsd(1.2D);
		raiseRank.setRank(1);
		raiseRank.setVolRmb(3223221.2232D);
		raiseRanks.add(raiseRank);
		RaiseRank raiseRank1 = new RaiseRank();
		raiseRank1.setCoinNo("btc");
		raiseRank1.setRate(12.2D);
		raiseRank1.setCloseRmb(11.3D);
		raiseRank1.setCloseUsd(1.2D);
		raiseRank1.setRank(1);
		raiseRank1.setVolRmb(3223221.2232D);
		raiseRanks.add(raiseRank1);
		return raiseRanks;
	}

	@ApiOperation(value = "币种详细信息", notes = "获取币种的详细信息和K线图信息")
	@ApiImplicitParam(name = "coin", value = "币种", paramType = "query", required = true, dataType = "String")
	@RequestMapping(value = "/coinInfo", method =  RequestMethod.POST)
	public CoinInfo coinInfo(@ApiParam String coin) {
		Gson gson = new Gson();
		CoinInfo coinInfo = new CoinInfo();
		System.out.println("=========" + coin);
		String symbol = coin.trim() + "usdt";
		//		获取兑换的汇率rmb usdt
		double exchangeRate = Double.valueOf(stringRedisTemplate.opsForValue().get(BaseConstant.EXCHANGE_RATE_RMB_USD));
//		获取币种详细信息
		String values = stringRedisTemplate.opsForValue().get(BaseConstant.HUOBI_CURRENCY_DETAIL + symbol);
		CoinSingle coinSingle = gson.fromJson(values, CoinSingle.class);
		coinInfo.setCloseUsd(coinSingle.getClose());
		coinInfo.setCloseRmb(coinSingle.getClose() * exchangeRate);
		coinInfo.setHighRmb(coinSingle.getHigh() * exchangeRate);
		coinInfo.setLowRmb(coinSingle.getLow() * exchangeRate);
		coinInfo.setVolRmb(coinSingle.getVol() * exchangeRate);
		coinInfo.setTs(coinSingle.getTs());
//先都给默认值
		coinInfo.setCoinNo(coin);
		coinInfo.setName("默认");
		coinInfo.setDescription("默认");
		coinInfo.setDistributionAmt("10000000");
		coinInfo.setMarketAmt("1000000");
		coinInfo.setTurnoverAmt("1000000");
		coinInfo.setWebsiteAddr("www.huobi.com");
		coinInfo.setWhitePaper("www.huobi.com");
		coinInfo.setIssueDate("2000-01-01");

//		日k线
		values = stringRedisTemplate.opsForValue().get(BaseConstant.HUOBI_CURRENCY_KLINE_DAY + symbol);
		List<CoinKline> coinKlinesDay = gson.fromJson(values, new TypeToken<List<CoinKline>>() {
		}.getType());
		coinInfo.setkLineDay(coinKlinesDay);
//		周k线
		values = stringRedisTemplate.opsForValue().get(BaseConstant.HUOBI_CURRENCY_KLINE_WEEK + symbol);
		List<CoinKline> coinKlinesWeek = gson.fromJson(values, new TypeToken<List<CoinKline>>() {
		}.getType());
		coinInfo.setkLineWeek(coinKlinesWeek);
		//		月k线
		values = stringRedisTemplate.opsForValue().get(BaseConstant.HUOBI_CURRENCY_KLINE_MONTH + symbol);
		List<CoinKline> coinKlinesMonth = gson.fromJson(values, new TypeToken<List<CoinKline>>() {
		}.getType());
		coinInfo.setkLineMonth(coinKlinesMonth);
		//		年k线
		values = stringRedisTemplate.opsForValue().get(BaseConstant.HUOBI_CURRENCY_KLINE_YEAR + symbol);
		List<CoinKline> coinKlinesYear = gson.fromJson(values, new TypeToken<List<CoinKline>>() {
		}.getType());
		coinInfo.setkLineYear(coinKlinesYear);
		return coinInfo;
	}

//	public


}
