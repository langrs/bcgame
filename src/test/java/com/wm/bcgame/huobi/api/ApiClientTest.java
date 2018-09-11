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
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author LZM
 * @description
 * @date 14:42 2018/9/10
 * @mondified
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiClientTest {
	private final Logger logger = LoggerFactory.getLogger(ApiClientTest.class);
    @Value("${huobi.key}")
    private  String API_KEY ;
    @Value("${huobi.secret}")
    private  String API_SECRET ;

    private ApiClient apiClient;

    @Before
    public void init(){
        apiClient = new ApiClient(API_KEY, API_SECRET);

    }

//    测试获取所有的币种
    @Test
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
