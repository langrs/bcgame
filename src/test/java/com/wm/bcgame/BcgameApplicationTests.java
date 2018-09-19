package com.wm.bcgame;

import com.wm.bcgame.base.QueryMap;
import com.wm.bcgame.model.SysParm;
import com.wm.bcgame.service.SysParmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BcgameApplicationTests {

	@Resource
	SysParmService sysParmService;

	@Test
	public void contextLoads() {
		System.out.println("ok");
	}

	@Test
	public void sysParmServiceInsert(){
		SysParm sysParm = new SysParm();
		sysParm.setparmCode(12L);
		sysParm.setparmValues("copy that");
		sysParm.setdescription("test insert");
		sysParmService.create(sysParm);
	}
	@Test
	public void sysParmServiceUpdate(){
		QueryMap queryMap = new QueryMap();
		queryMap.put("parmCode",12L);
		SysParm sysParm = sysParmService.getOne(queryMap);
		sysParm.setparmValues("lzm");
		sysParm.setdescription("test descripton");
		sysParmService.update(sysParm);
	}

}
