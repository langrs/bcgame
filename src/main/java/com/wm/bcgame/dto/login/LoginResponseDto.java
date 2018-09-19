package com.wm.bcgame.dto.login;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author LZM
 * @description 登录首页返回信息
 * @date 11:37 2018/9/14
 * @mondified
 **/
public class LoginResponseDto {
	@ApiModelProperty(value = "轮播")
	private List<SlideshowDto> slideshowDtos;
	@ApiModelProperty(value = "公告")
	private List<UserNoticeDto> userNoticeDtos;
	@ApiModelProperty(value = "游戏热度榜")
	private List<GameDto> gameDtos;

	public List<SlideshowDto> getSlideshowDtos() {
		return slideshowDtos;
	}

	public void setSlideshowDtos(List<SlideshowDto> slideshowDtos) {
		this.slideshowDtos = slideshowDtos;
	}

	public List<UserNoticeDto> getUserNoticeDtos() {
		return userNoticeDtos;
	}

	public void setUserNoticeDtos(List<UserNoticeDto> userNoticeDtos) {
		this.userNoticeDtos = userNoticeDtos;
	}

	public List<GameDto> getGameDtos() {
		return gameDtos;
	}

	public void setGameDtos(List<GameDto> gameDtos) {
		this.gameDtos = gameDtos;
	}
}
