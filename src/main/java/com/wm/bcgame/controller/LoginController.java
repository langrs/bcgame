package com.wm.bcgame.controller;

import com.wm.bcgame.base.BaseConstant;
import com.wm.bcgame.base.QueryMap;
import com.wm.bcgame.dto.CoinSingle;
import com.wm.bcgame.dto.PageDataDto;
import com.wm.bcgame.dto.ResponseDto;
import com.wm.bcgame.dto.login.GameDto;
import com.wm.bcgame.dto.login.LoginResponseDto;
import com.wm.bcgame.dto.login.SlideshowDto;
import com.wm.bcgame.dto.login.UserNoticeDto;
import com.wm.bcgame.model.SysCoin;
import com.wm.bcgame.model.SysGame;
import com.wm.bcgame.model.SysUser;
import com.wm.bcgame.model.UserNotice;
import com.wm.bcgame.service.SysCoinService;
import com.wm.bcgame.service.SysGameService;
import com.wm.bcgame.service.UserNoticeService;
import com.wm.bcgame.taskService.BusinessException;
import com.wm.bcgame.taskService.CoinService;
import com.wm.bcgame.taskService.CoreException;
import com.wm.bcgame.taskService.LoginService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/login")
@Api(value = "登录相关", description = "登录相关")
public class LoginController {

	@Resource
	LoginService loginService;
	@Resource
	UserNoticeService userNoticeService;
	@Resource
	SysGameService sysGameService;
	@Resource
	SysCoinService sysCoinService;
	@Resource
	CoinService coinService;

	@ApiOperation(value = "登录首页信息", notes = "获取公告/轮播图/热度榜")
	@ApiImplicitParam(name = "userId", value = "用户ID", paramType = "query", required = false, dataType = "Long")
	@RequestMapping(value = "/api", method =  RequestMethod.POST)
	public ResponseDto<LoginResponseDto> loginApi(@ApiParam Long userId){
		ResponseDto<LoginResponseDto> responseDto = new ResponseDto();
		LoginResponseDto loginResponseDto = new LoginResponseDto();
//		获取用户公告
		List<UserNoticeDto> userNoticeDtos = loginService.getUserNotice(userId);
//		获取轮播列表
		List<SlideshowDto> slideshowDtos = loginService.getSlideShow();
//		获取热度榜
		List<GameDto> gameDtos = loginService.getHeatGame(1,10,0);

		loginResponseDto.setUserNoticeDtos(userNoticeDtos);
		loginResponseDto.setSlideshowDtos(slideshowDtos);
		loginResponseDto.setGameDtos(gameDtos);
		responseDto.setStatus(BaseConstant.STATUS_OK);
		responseDto.setData(loginResponseDto);
		return  responseDto;
	}

	@ApiOperation(value = "用户阅读公告", notes = "用户阅读公告后台设置该公告为已经阅读")
	@ApiImplicitParams({
	@ApiImplicitParam(name = "userId", value = "用户ID", paramType = "query", required = true, dataType = "Long"),
	@ApiImplicitParam(name = "noticeId", value = "公告ID", paramType = "query", required = true, dataType = "Long")
	})
	@RequestMapping(value = "/userReadNotice", method =  RequestMethod.POST)
	public void userReadNotice(@ApiParam Long userId,@ApiParam Long noticeId){
		UserNotice userNotice = new UserNotice();
		userNotice.setuserId(userId);
		userNotice.setnoticeId(noticeId);
		userNoticeService.create(userNotice);
	}


	@ApiOperation(value = "获取游戏列表", notes = "分页获取热度榜、所有游戏的列表信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "type", value = "获取类型:0游戏热度榜 1全部游戏", paramType = "query", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "pageStart", value = "开始页数", paramType = "query", required = true, dataType = "Long")
	})
	@RequestMapping(value = "/getGamePage", method =  RequestMethod.POST)
	public ResponseDto<PageDataDto<List<GameDto>>> getGamePage(@ApiParam Long type, @ApiParam Long pageSize, @ApiParam Long pageStart){
		ResponseDto<PageDataDto<List<GameDto>>> responseDto = new ResponseDto<>();
		PageDataDto<List<GameDto>> pageDataDto = new PageDataDto<>();
		Long count = 0L;
		String coinNo;
		List<GameDto> gameDtos = new ArrayList<>();
		QueryMap queryMap = new QueryMap();
		queryMap.put("pageSize",pageSize);
		queryMap.put("pageStart",(pageStart - 1)*pageSize);
		queryMap.put("disabled",0);
		List<SysGame> sysGames = sysGameService.getListPage(queryMap);
		for(SysGame sysGame:sysGames){
			GameDto gameDto = new GameDto();
			gameDto.setGameName(sysGame.getname());
//			获取币种编号
			SysCoin sysCoin = sysCoinService.get(sysGame.getcoinId());
			coinNo = sysCoin.getcoinNo();
			gameDto.setCoinName(coinNo);
			gameDto.setIcon(sysGame.geticon());
			gameDto.setHeat(sysGame.getheat());
			gameDto.setPlayers(sysGame.getplayers());
			gameDto.setTrend(sysGame.gettrend());
//			如果获取全部游戏的话，需要拿到24H的成交量
			if(type == 1){
//				获取单个币种实时数据
				CoinSingle coinSingle = coinService.getCoinSingle(coinNo);
//				获取币种汇率
				double exchangeRate = coinService.getExchangeRate(coinNo);
				gameDto.setVolRmb(coinSingle.getVol() * exchangeRate);
			}
			gameDtos.add(gameDto);
		}
//		计算页
		queryMap.clear();
		queryMap.put("disabled",0);
		count = sysGameService.getPageCount(queryMap);
		pageDataDto.setCurrentPage(pageStart);
		pageDataDto.setPageSize(pageSize);
		pageDataDto.setDataList(gameDtos);
		if(count%pageSize != 0 ){
			pageDataDto.setTotalPage(count/pageSize + 1);
		}else {
			pageDataDto.setTotalPage(count/pageSize);
		}
		responseDto.setStatus(BaseConstant.STATUS_OK);
		responseDto.setData(pageDataDto);
		return responseDto;
	}


	@ApiOperation(value = "异常测试", notes = "异常测试")
	@ApiImplicitParam(name = "code", value = "编码", paramType = "query", required = true, dataType = "Long")
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public List<SysUser> test(@ApiParam Long code) throws CoreException{
		if(code == 0){
			CoreException businessException = new CoreException();
			businessException.setErrMsg("有异常抛出呀，兄弟!!!");
			throw businessException;
		}else{
			List<SysUser> sysUsers = new ArrayList<>();
			SysUser sysUser = new SysUser();
			sysUser.setid(211L);
			sysUser.setuserName("lzm");
			sysUsers.add(sysUser);
			return sysUsers;
		}
	}
}
