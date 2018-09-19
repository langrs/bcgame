package com.wm.bcgame.taskService;

import com.google.gson.Gson;
import com.wm.bcgame.base.BaseConstant;
import com.wm.bcgame.dto.CoinSingle;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LZM
 * @description
 * @date 14:17 2018/9/15
 * @mondified
 **/
@Service
public class CoinService {
	@Resource
	StringRedisTemplate stringRedisTemplate;

	//获取单个币种的实时数据
	public CoinSingle getCoinSingle(String coinNo){
		Gson gson = new Gson();
		String symbol = coinNo + "usdt";
		String values = stringRedisTemplate.opsForValue().get(BaseConstant.HUOBI_CURRENCY_DETAIL+symbol);
		CoinSingle coinSingle = gson.fromJson(values,CoinSingle.class);
		return coinSingle;
	}
	//获取单个币种的汇率
	public double getExchangeRate(String coinNo){
		String exchangeRate = stringRedisTemplate.opsForValue().get(BaseConstant.EXCHANGE_RATE_RMB_USD);
		return Double.valueOf(exchangeRate);
	}

}
