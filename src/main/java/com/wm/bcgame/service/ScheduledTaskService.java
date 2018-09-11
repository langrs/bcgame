package com.wm.bcgame.service;

import com.wm.bcgame.base.BaseConstant;
import com.wm.bcgame.huobi.api.ApiClient;
import com.wm.bcgame.huobi.response.CurrencysResponse;
import com.wm.bcgame.huobi.response.DetailResponse;
import com.wm.bcgame.huobi.response.Details;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {
	private final Logger logger = LoggerFactory.getLogger(Scheduled.class);

	private final static String BASE_CURRENCY = "usdt";

	@Value("${huobi.key}")
	private  String API_KEY ;
	@Value("${huobi.secret}")
	private  String API_SECRET ;
	@Autowired
	RedisTemplate redisTemplate;

	private ApiClient apiClient ;
    @Scheduled(fixedRate = 120000)
    public void currencys(){
		apiClient = new ApiClient(API_KEY,API_SECRET);
    	String symbol = "ethusdt";
		CurrencysResponse currencysResponse = apiClient.currencys(symbol);
		logger.info("======currencys====status:{};data:{}",currencysResponse.getStatus(),currencysResponse.getData());
//		写入redis
		if(currencysResponse.getStatus().equals("ok")){
			String values = currencysResponse.getData().toString();
			values = values.substring(1,values.length() - 1);
			redisTemplate.opsForValue().set(BaseConstant.HUOBI_CURRENCY, values);
		}
    }
//循环获取单个symbol的信息
	@Scheduled(fixedRate = 120000)
	public void getDetail(){
		apiClient = new ApiClient(API_KEY,API_SECRET);

    	String val = redisTemplate.opsForValue().get(BaseConstant .HUOBI_CURRENCY).toString();
    	String[] arr = val.split(",");

    	for(String coin:arr){
    		coin = coin.trim();
			if(coin.equals(BASE_CURRENCY)){
				continue;
			}
//    		组合symbol
			String symbol = coin + "usdt";
			try{
				DetailResponse<Details> detailResponse = apiClient.detail(symbol);
				logger.info("==获取币种信息成功==币种:{},返回值:{}",symbol,detailResponse.getTick().toString());
				if(detailResponse.getStatus().equals("ok")){
//				写入redis

				}

			}catch (Exception e){
				logger.error("======获取币种信息失败======币种:{}======错误信息:{}",symbol,e.getMessage() );
			}
		}
	}

}
