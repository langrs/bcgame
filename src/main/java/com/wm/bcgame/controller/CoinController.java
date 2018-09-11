package com.wm.bcgame.controller;

import com.wm.bcgame.dto.ResponseDto;
import com.wm.bcgame.dto.RaiseRank;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LZM
 * @description 获取币种相关信息
 * @date 11:36 2018/9/11
 * @mondified
 **/

@RestController
@RequestMapping("/coinList")
@Api("获取币种相关信息")
public class CoinController {
	private static final Logger logger= LoggerFactory.getLogger(CoinController.class);

	@Autowired
	RedisTemplate redisTemplate;

	@ApiOperation(value = "涨幅榜", notes = "获取按涨幅排位的前30位币种信息")
	@ApiImplicitParam(name = "raiseType", value = "涨跌标志 涨幅0/跌幅1", paramType = "path", required = true, dataType = "Integer")
	@RequestMapping(value = "/raiseRank/{raiseType}", method = RequestMethod.GET)
	public ResponseDto<List<RaiseRank>> raiseRank(@PathVariable Integer raiseType){

		return null;
	}
}
