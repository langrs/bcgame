package com.wm.bcgame.controller;

import com.wm.bcgame.dto.DataDto;
import com.wm.bcgame.dto.integral.IntegralTaskDto;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LZM
 * @description
 * @date 16:18 2018/9/19
 * @mondified
 **/
@Api(value = "积分相关",description = "积分相关")
@RestController
@RequestMapping("/integral")
public class IntegralController {

	@ApiOperation(value = "获取积分兑换代币汇率", notes = "获取积分兑换代币汇率:汇率含义为N个积分兑换1个代币")
	@ApiImplicitParam(name = "coinNo", value = "币种", paramType = "query", required = true, dataType = "String",defaultValue = "db")
	@RequestMapping(value = "/getIntegralCoinExchangeRate", method = RequestMethod.POST)
	public DataDto<String> getIntegralCoinExchangeRate(@ApiParam String coinNo){
		double exchangeRate = 100;
		DataDto<String> dataDto = new DataDto<>();
		dataDto.setDataList(String.valueOf(exchangeRate));
		return dataDto;
	}

	@ApiOperation(value = "获取积分任务", notes = "获取每日积分任务、成长积分任务、最新积分公告列表")
	@ApiImplicitParam(name = "userId", value = "用户ID", paramType = "query", required = true, dataType = "Long")
	@RequestMapping(value = "/getIntegralTask", method = RequestMethod.POST)
	public IntegralTaskDto getIntegralTask(@ApiParam Long userId){
		IntegralTaskDto integralTaskDto = new IntegralTaskDto();

		return integralTaskDto;
	}
//	@ApiOperation(value = "积分变动", notes = "积分增加和减少")
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "type", value = "更新密码类型:0用户密码 1积分密码", paramType = "query", required = true, dataType = "Long"),
//			@ApiImplicitParam(name = "userId", value = "用户ID", paramType = "query", required = true, dataType = "Long"),
//			@ApiImplicitParam(name = "passwd", value = "密码-MD5", paramType = "query", required = true, dataType = "String")
//	})
//	@RequestMapping(value = "", method = RequestMethod.POST)
//	public void addIntegral(@ApiParam Long userId,@ApiParam Long operationType,@ApiParam Double integral){
//
//	}
}
