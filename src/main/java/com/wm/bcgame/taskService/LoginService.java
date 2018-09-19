package com.wm.bcgame.taskService;

import com.wm.bcgame.base.BaseConstant;
import com.wm.bcgame.base.QueryMap;
import com.wm.bcgame.dto.login.GameDto;
import com.wm.bcgame.dto.login.SlideshowDto;
import com.wm.bcgame.dto.login.UserNoticeDto;
import com.wm.bcgame.model.*;
import com.wm.bcgame.service.*;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author LZM
 * @description
 * @date 13:54 2018/9/14
 * @mondified
 **/
@Service
public class LoginService {
	@Resource
	UserNoticeService userNoticeService;
	@Resource
	SysNoticeService sysNoticeService;
	@Resource
	SysSlideshowService sysSlideshowService;
	@Resource
	SysGameService sysGameService;
	@Resource
	SysCoinService sysCoinService;
	@Resource
	StringRedisTemplate stringRedisTemplate;
	@Resource
	SysUserService sysUserService;

//	验证码有效时长--手机2分钟  邮件1天
	private static Integer AUTH_CODE_EXPIRE_SECOND_PHONE = 120;
	private static Integer AUTH_CODE_EXPIRE_SECOND_EMAIL = 86400;
//	验证码长度

	private static Integer AUTH_CODE_LEN = 6;
//获取用户的公告列表
	public List<UserNoticeDto> getUserNotice(Long userId){
		StringBuilder noticeIdList = new StringBuilder();
		QueryMap queryMap = new QueryMap();
		queryMap.put("disabled",0);
		List<SysNotice> sysNotices = sysNoticeService.getList(queryMap);

//		如果用户已经登录，则需要处理公告已经阅读的标记
		if(userId != null) {
			queryMap.put("userId", userId);
			List<UserNotice> userNotices = userNoticeService.getList(queryMap);
			for (UserNotice userNotice : userNotices) {
				noticeIdList.append("[").append(userNotice.getnoticeId().toString()).append("]");
			}
		}
		List<UserNoticeDto> userNoticeDtos = new ArrayList();
		for(SysNotice sysNotice:sysNotices){

			UserNoticeDto userNoticeDto = new UserNoticeDto();
			userNoticeDto.setTitle(sysNotice.gettitle());
			userNoticeDto.setDescription(sysNotice.getdescription());
			userNoticeDto.setCreateTime(sysNotice.getCreateTime());
			userNoticeDto.setId(sysNotice.getid());
//			用户是否已经阅读过
			int readFlag = 0;
			if(userId != null){
				int indexOf = noticeIdList.indexOf("[" + sysNotice.getid().toString() + "]");
				if( indexOf >= 0){
					readFlag = 1;
				}
			}
			userNoticeDto.setNoticeStatus(readFlag);
			userNoticeDtos.add(userNoticeDto);
		}
		return userNoticeDtos;
	}
//	获取轮播榜
	public List<SlideshowDto> getSlideShow(){
		QueryMap queryMap  = new QueryMap();
		queryMap.put("disabled",0);
		List<SysSlideshow> sysSlideshows = sysSlideshowService.getList(queryMap);
		List<SlideshowDto> slideshowDtos = new ArrayList<>();
		for(SysSlideshow sysSlideshow:sysSlideshows){
			SlideshowDto slideshowDto = new SlideshowDto();
			slideshowDto.setName(sysSlideshow.getname());
			slideshowDto.setDescription(sysSlideshow.getdescription());
			slideshowDto.setUrl(sysSlideshow.geturl());
			slideshowDtos.add(slideshowDto);
		}
		return slideshowDtos;
	}
//获取游戏热度榜--最多返回10条记录
	public List<GameDto> getHeatGame(int pageStart, int pageSize, int type){
		List<GameDto> gameDtos = new ArrayList<>();
		QueryMap queryMap = new QueryMap();
		queryMap.put("pageStart",pageStart);
		queryMap.put("pageSize",pageSize);
		queryMap.put("disabled",0);
		List<SysGame> sysGames = sysGameService.getListPage(queryMap);
		for(SysGame sysGame:sysGames){
			GameDto gameDto = new GameDto();
			gameDto.setGameName(sysGame.getname());
//			币种名称
			SysCoin sysCoin = sysCoinService.get(sysGame.getcoinId());
			gameDto.setCoinName(sysCoin.getcoinNo());
			gameDto.setHeat(sysGame.getheat());
			gameDto.setIcon(sysGame.geticon());
			gameDto.setPlayers(sysGame.getplayers());
			gameDto.setTrend(sysGame.gettrend());
//			如果查看全部游戏页面，则需要返回24H的交易额
			if(type == 1){

			}
			gameDtos.add(gameDto);
		}
		return gameDtos;
	}

	//	生成N位验证码并插入到redis以备教养
	//codeNo :手机/邮箱编号
	//len 验证码长度
	public String getAuthCode(Long sendType,String codeNo){
		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder(AUTH_CODE_LEN);
		for(int i =0;i < AUTH_CODE_LEN;i++){
			int val = random.nextInt(10);
			stringBuilder.append( val);
		}
		String authCode = stringBuilder.toString();
//		设置redis
		stringRedisTemplate.opsForValue().set(BaseConstant.AUTHOR_CODE + codeNo,authCode);
		if(sendType == 0){
			stringRedisTemplate.expire(BaseConstant.AUTHOR_CODE + codeNo,AUTH_CODE_EXPIRE_SECOND_PHONE,SECONDS);
		}else {
			stringRedisTemplate.expire(BaseConstant.AUTHOR_CODE + codeNo,AUTH_CODE_EXPIRE_SECOND_EMAIL,SECONDS);
		}
		return  authCode;
	}
//	校验验证码
	public boolean checkAuthCode(String codeNo,String authCode){
		String getAuthCode;
		getAuthCode = stringRedisTemplate.opsForValue().get(BaseConstant.AUTHOR_CODE+codeNo);
		if(authCode.equals(getAuthCode)){
			return true;
		}else{
			return false;
		}
	}
//	判读是否有设置积分密码
	public boolean haveIntegralPasswd(Long userId){
		SysUser user = sysUserService.get(userId);
		if(user != null && user.getintegral() == 0){
			return false;
		}else{
			return true;
		}
	}
//	修改/设置密码积分密码
//	type :0用户密码 1积分密码
	public void setPasswd(Long type,Long userId,String passwd){
		SysUser sysUser = sysUserService.get(userId);
		if(type == 0){
			sysUser.setpasswd(passwd);
		}else{
			sysUser.setintegralPassword(passwd);
			sysUser.setintegral(1L);
		}
		sysUserService.update(sysUser);
	}
//	用户绑定邮箱地址
	public boolean setUserEmail(Long userId,String email){
		SysUser sysUser = sysUserService.get(userId);
		if(sysUser != null){
			sysUser.setemail(email);
			sysUserService.update(sysUser);
			return true;
		}else{
			return false;
		}
	}
}
