package com.wm.bcgame.huobi.api;

import com.wm.bcgame.huobi.response.CurrencysResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Set;


/**
 * @author LZM
 * @description
 * @date 14:42 2018/9/10
 * @mondified
 **/
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ApiClientTest {
	private final Logger logger = LoggerFactory.getLogger(ApiClientTest.class);
    @Value("${huobi.key}")
    private  String API_KEY ;
    @Value("${huobi.secret}")
    private  String API_SECRET ;

    private ApiClient apiClient;

    @Resource
	StringRedisTemplate stringRedisTemplate;


	@Before
	public void init(){
		apiClient = new ApiClient(API_KEY, API_SECRET);

	}

//	@Test
	public void testZset(){
		String key = "lzmZset";
		String str = stringRedisTemplate.opsForValue().get("HuobiCurrencyKLineYearthetausdt").toString();
		ZSetOperations opsForZSet;
		opsForZSet = stringRedisTemplate.opsForZSet();
		opsForZSet.add(key,"val1",1);
		opsForZSet.add(key,"val2",2);
		opsForZSet.add(key,"val9",9);
		opsForZSet.add(key,"val3.4",20);
		opsForZSet.add(key,"val3.2",3);
		opsForZSet.add(key,"val3.7",4);

		Set<String> val = opsForZSet.reverseRange(key,0,100);
		for(String a:val){
			System.out.println(a);
		}
//		System.out.println("------"  + opsForZSet.range(key,0,100));
		System.out.println("====="+str);
	}
//    测试获取所有的币种
//    @Test
    public void currencys(){
    	String symbol ="ethusdt";
		CurrencysResponse currencys  = apiClient.currencys(symbol);
		if(currencys.getStatus().equals("ok")){
			System.out.println("======================获取到的币种信息为======================");
			System.out.println(currencys.getData());
			logger.info("======================获取到的币种信息为======================");
			logger.info(currencys.getData().toString());

		}
		Assert.assertEquals("ok",currencys.getStatus());
    }

}
