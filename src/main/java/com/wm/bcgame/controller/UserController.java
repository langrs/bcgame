package com.wm.bcgame.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.google.gson.Gson;
import com.wm.bcgame.base.BaseConstant;
import com.wm.bcgame.base.QueryMap;
import com.wm.bcgame.comm.BusinessException;
import com.wm.bcgame.comm.Error;
import com.wm.bcgame.dto.CoinSingle;
import com.wm.bcgame.dto.DataDto;
import com.wm.bcgame.dto.ResponseDto;
import com.wm.bcgame.dto.favorite.FavoriteDto;
import com.wm.bcgame.dto.login.GameDto;
import com.wm.bcgame.dto.user.CheckPicDto;
import com.wm.bcgame.model.SysCoin;
import com.wm.bcgame.model.SysGame;
import com.wm.bcgame.model.UserFavorite;
import com.wm.bcgame.model.UserHistory;
import com.wm.bcgame.service.SysCoinService;
import com.wm.bcgame.service.SysGameService;
import com.wm.bcgame.service.UserFavoriteService;
import com.wm.bcgame.service.UserHistoryService;
import com.wm.bcgame.taskService.CoinService;
import com.wm.bcgame.taskService.LoginService;
import com.wm.bcgame.taskService.MailService;
import io.swagger.annotations.*;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author LZM
 * @description
 * @date 17:53 2018/9/14
 * @mondified
 **/
@RestController
@RequestMapping(value = "/user")
@Api(value = "用户相关",description = "用户相关")
public class UserController {
	@Resource
	UserFavoriteService userFavoriteService;
	@Resource
	SysCoinService sysCoinService;
	@Resource
	SysGameService sysGameService;
	@Resource
	StringRedisTemplate stringRedisTemplate;
	@Resource
	UserHistoryService userHistoryService;
	@Resource
	CoinService coinService;
	@Resource
	LoginService loginService;
	@Resource
	MailService mailService;
	@ApiOperation(value = "获取用户收藏列表", notes = "获取用户收藏列表：游戏收藏和币种收藏")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", value = "用户ID", paramType = "query", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "favoriteType", value = "收藏类型:0游戏,1币种", paramType = "query", required = true, dataType = "Integer")
	})
	@RequestMapping(value = "/getUserFavorite", method = RequestMethod.POST)
	public List<FavoriteDto> getUserFavorite(@ApiParam Long userId, @ApiParam int favoriteType)throws BusinessException{
		Gson gson = new Gson();
		QueryMap queryMap = new QueryMap();
		queryMap.put("disabled",0);
		queryMap.put("userId",userId);
		queryMap.put("favoriteType",favoriteType);
		List<FavoriteDto> favoriteDtos = new ArrayList<>();
		List<UserFavorite> userFavorites = userFavoriteService.getList(queryMap);
//		汇率
		double exchageRate = Double.valueOf(stringRedisTemplate.opsForValue().get(BaseConstant.EXCHANGE_RATE_RMB_USD));
//		转换dto返回值
		for(UserFavorite userFavorite:userFavorites){
			FavoriteDto favoriteDto = new FavoriteDto();
			Long id = userFavorite.getFavoriteId();
			if(favoriteType == 0){ //游戏
				SysGame sysGame = sysGameService.get(id);

				favoriteDto.setId(id);
				favoriteDto.setGameName(sysGame.getName());
				SysCoin sysCoin = sysCoinService.get(sysGame.getCoinId());
				favoriteDto.setCoinNo(sysCoin.getCoinNo());
				favoriteDto.setCoinName(sysCoin.getName());
				favoriteDto.setIcon(sysGame.getIcon());
				favoriteDto.setPlayers(sysGame.getPlayers());
			}else{ //币种
				SysCoin sysCoin = sysCoinService.get(id);
				favoriteDto.setId(id);
				favoriteDto.setCoinName(sysCoin.getName());
				favoriteDto.setCoinNo(sysCoin.getCoinNo());
				String symbol = sysCoin.getCoinNo().trim() + "usdt";
//				从redis中获取最新的币种信息
				String detail = stringRedisTemplate.opsForValue().get(BaseConstant.HUOBI_CURRENCY_DETAIL+symbol);
				CoinSingle coinSingle = gson.fromJson(detail,CoinSingle.class);
				if(coinSingle != null){
					favoriteDto.setCloseRmb(coinSingle.getClose() * exchageRate);
					favoriteDto.setCloseUsd(coinSingle.getClose());
					favoriteDto.setVolRmb(coinSingle.getVol()*exchageRate);
					favoriteDto.setRate((coinSingle.getClose() - coinSingle.getOpen())*100/coinSingle.getOpen());
				}
			}
			favoriteDtos.add(favoriteDto);
		}
		return favoriteDtos;
	}
	@ApiOperation(value = "用户更新收藏信息", notes = "用户更新收藏信息：加入收藏夹或取消收藏")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", value = "用户ID", paramType = "query", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "favoriteOp", value = "操作类型:0加入收藏,1取消收藏", paramType = "query", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "favoriteType", value = "收藏类型:0游戏,1币种", paramType = "query", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "favoriteId", value = "收藏内容ID", paramType = "query", required = true, dataType = "Long")
	})
	@RequestMapping(value = "/updateUserFavorite", method = RequestMethod.POST)
	public void updateUserFavorite(@ApiParam Long userId,@ApiParam Long favoriteOp,@ApiParam Long favoriteType,@ApiParam Long favoriteId ) throws BusinessException{
		QueryMap queryMap = new QueryMap();
		queryMap.put("userId",userId);
		queryMap.put("favoriteType",favoriteType);
		queryMap.put("favoriteId",favoriteId);
//		先查找，如果存在则更新，否则插入
		UserFavorite userFavorite = userFavoriteService.getOne(queryMap);
		if(userFavorite != null){
			userFavorite.setDisabled(favoriteOp);
			userFavoriteService.update(userFavorite);
		}else{
			userFavorite = new UserFavorite();
			userFavorite.setFavoriteId(favoriteId);
			userFavorite.setFavoriteType(favoriteType);
			userFavorite.setUserId(userId);
			userFavorite.setDisabled(favoriteOp);
			userFavoriteService.create(userFavorite);
		}

	}

	@ApiOperation(value = "获取用户历史玩过的游戏", notes = "获取用户历史玩过的游戏")
	@ApiImplicitParam(name = "userId", value = "用户ID", paramType = "query", required = true, dataType = "Long")
	@RequestMapping(value = "/getHistoryGame", method = RequestMethod.POST)
	public List<GameDto> getHistoryGame(@ApiParam Long userId ) throws BusinessException{
//		获取汇率
		double exchangeRate =  coinService.getExchangeRate("");
		List<GameDto> gameDtos = new ArrayList<>();
		QueryMap queryMap = new QueryMap();
		queryMap.put("disabled",0);
		queryMap.put("userId",userId);
		queryMap.put("historyType",0); //0获取历史游戏
		List<UserHistory> userHistorys = userHistoryService.getList(queryMap);
		for(UserHistory userHistory:userHistorys){
			Long gameId = userHistory.getHistoryId();
			SysGame sysGame = sysGameService.get(gameId);
//			获取币种名称
			Long coinId = sysGame.getCoinId();
			SysCoin sysCoin = sysCoinService.get(coinId);
//获取币种成交量
			CoinSingle coinSingle = coinService.getCoinSingle(sysCoin.getCoinNo());
			GameDto gameDto = new GameDto();
			gameDto.setGameName(sysGame.getName());
//			币种名称
			gameDto.setCoinName(sysCoin.getCoinNo());
			gameDto.setPlayers(sysGame.getPlayers());
			gameDto.setIcon(sysGame.getIcon());
//			24H成交量RMB
			gameDto.setVolRmb(coinSingle.getVol()*exchangeRate);
			gameDtos.add(gameDto);
		}
		return gameDtos;
	}

	@ApiOperation(value = "获取验证图片", notes = "返回验证图片的url地址")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "sendType", value = "类型:0发送手机验证码 1发邮箱验证码", paramType = "query", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "sendNo", value = "手机号/邮箱地址", paramType = "query", required = true, dataType = "String")
	})
	@RequestMapping(value = "/getCheckPic", method = RequestMethod.POST)
	public CheckPicDto getCheckPic(@ApiParam Long sendType,@ApiParam String sendNo) throws BusinessException{
		CheckPicDto checkPicDto =  new CheckPicDto();
		String url= "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1537268483864&di=be1add8f527d400eda320243273d1cd4&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dpixel_huitu%252C0%252C0%252C294%252C40%2Fsign%3De3bf833fa4c3793169658e6982bcd229%2F9f2f070828381f30726bcc90a2014c086e06f09d.jpg";
		checkPicDto.setUrl(url);
		String validCode = loginService.getValidCode(sendType,sendNo);
		checkPicDto.setValidCode(validCode);
		return checkPicDto;
	}

	@ApiOperation(value = "发送验证码", notes = "发送手机/邮箱验证码")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "sendType", value = "类型:0发送手机验证码 1发邮箱验证码", paramType = "query", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "sendNo", value = "手机号/邮箱地址", paramType = "query", required = true, dataType = "String"),
			@ApiImplicitParam(name = "validCode", value = "身份码", paramType = "query", required = true, dataType = "String")
	})
	@RequestMapping(value = "/sendAuthCode", method = RequestMethod.POST)
	public void sendAuthCode(@ApiParam Long sendType,@ApiParam String sendNo,@ApiParam String validCode) throws BusinessException{
		boolean flag = false;
		String authCode =  loginService.getAuthCode(sendType,sendNo,validCode);
		//发送短信或者邮件
		if(sendType == 0){
			flag = true;
		}else{
			String deliver = BaseConstant.EMAIL_SENDER;
			String[] receiver = {sendNo};
			String[] carbonCopy = null;
			String subject = BaseConstant.EMAIL_TITLE;
			String content = BaseConstant.EMAIL_AUTH_CODE + authCode;
			flag = mailService.sendSimpleEmail(deliver, receiver, carbonCopy, subject, content);
		}
		if(!flag){
			BusinessException businessException = new BusinessException();
			businessException.setError(Error.OPERATION_ERROR);
			throw businessException;
		}
	}
	@ApiOperation(value = "校验验证码", notes = "校验手机验证码/邮箱验证码的正确性")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "sendType", value = "类型:0发送手机验证码 1发邮箱验证码", paramType = "query", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "sendNo", value = "手机号/邮箱地址", paramType = "query", required = true, dataType = "String"),
			@ApiImplicitParam(name = "authCode", value = "用户接收到的验证码", paramType = "query", required = true, dataType = "String")
	})
	@RequestMapping(value = "/checkAuthCode", method = RequestMethod.POST)
	public void checkAuthCode(@ApiParam Long sendType, @ApiParam String sendNo, @ApiParam String authCode) throws BusinessException{

		boolean flag = loginService.checkAuthCode(sendNo,authCode);
		if (!flag) {
			BusinessException businessException = new BusinessException();
			businessException.setError(Error.OPERATION_ERROR);
			throw businessException;
		}
	}

//	public ResponseDto
	@ApiOperation(value = "是否用户已经设置积分密码", notes = "是否用户已经设置积分密码")
	@ApiImplicitParam(name = "userId", value = "用户ID", paramType = "query", required = true, dataType = "Long")
	@RequestMapping(value = "/haveIntegralPasswd", method = RequestMethod.POST)
	public void haveIntegralPasswd(@ApiParam Long userId) throws BusinessException{
		boolean flag = loginService.haveIntegralPasswd(userId);
		if(!false){
			BusinessException businessException = new BusinessException();
			businessException.setError(Error.OPERATION_ERROR);
			throw businessException;
		}
	}
	@ApiOperation(value = "更新密码", notes = "更新积分密码/用户密码")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "type", value = "更新密码类型:0用户密码 1积分密码", paramType = "query", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "userId", value = "用户ID", paramType = "query", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "passwd", value = "密码-MD5", paramType = "query", required = true, dataType = "String")
	})
	@RequestMapping(value = "/setUserPasswd", method = RequestMethod.POST)
	public void setUserPasswd(@ApiParam Long type,@ApiParam Long userId,@ApiParam String passwd) throws BusinessException{
			loginService.setPasswd(type,userId,passwd);
	}

	@ApiOperation(value = "用户绑定邮箱", notes = "用户绑定邮箱")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", value = "用户ID", paramType = "query", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "email", value = "邮箱地址", paramType = "query", required = true, dataType = "String")
	})
	@RequestMapping(value = "/setUserEmail", method = RequestMethod.POST)
	public void setUserEmail(@ApiParam Long userId,@ApiParam String email) throws BusinessException{
		loginService.setUserEmail(userId,email);
	}

}
