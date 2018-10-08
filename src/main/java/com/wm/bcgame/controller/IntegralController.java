package com.wm.bcgame.controller;

import com.wm.bcgame.dto.DataDto;
import com.wm.bcgame.dto.integral.DaibiDto;
import com.wm.bcgame.dto.integral.IntegralTaskDto;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
	public DaibiDto getIntegralCoinExchangeRate(@ApiParam String coinNo){
		DaibiDto dataDto = new DaibiDto();
		dataDto.setCoinNo("db");
		dataDto.setName("代币");
		dataDto.setExchangeRate("100");
		dataDto.setLastModifiedTime("2018-10-01");
		return dataDto;
	}

	@ApiOperation(value = "获取积分任务", notes = "获取每日积分任务、成长积分任务、最新积分公告列表")
	@ApiImplicitParam(name = "userId", value = "用户ID", paramType = "query", required = true, dataType = "Long")
	@RequestMapping(value = "/getIntegralTask", method = RequestMethod.POST)
	public IntegralTaskDto getIntegralTask(@ApiParam Long userId){
		IntegralTaskDto integralTaskDto = new IntegralTaskDto();

		return integralTaskDto;
	}

	@ApiOperation(value = "领取任务奖励",notes = "领取任务的积分奖励")
		@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", value = "用户ID", paramType = "query", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "taskId", value = "任务ID", paramType = "query", required = true, dataType = "Long")
	})
	@RequestMapping(value = "/getIntegralReward",method = RequestMethod.POST)
	public DataDto<String> getIntegralReward(@ApiParam Long userId,@ApiParam Long taskId){
		DataDto<String> dataDto = new DataDto<>();

		return dataDto;
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
