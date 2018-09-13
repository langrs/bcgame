package com.wm.bcgame.controller;

import com.wm.bcgame.dto.RaiseRank;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class LoginController {

	@RequestMapping(value = "/api")
	public RaiseRank apiTest(){
		RaiseRank raiseRank = new RaiseRank();
		raiseRank.setCoinNo("0001");
		raiseRank.setCloseRmb(100);
		return raiseRank;
	}

}
