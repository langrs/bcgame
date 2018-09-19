package com.wm.bcgame.dto.login;

import com.wm.bcgame.base.BaseDto;
import com.wm.bcgame.taskService.LoginService;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author LZM
 * @description
 * @date 11:40 2018/9/14
 * @mondified
 **/
public class GameDto extends BaseDto {
	@ApiModelProperty(value = "游戏图标")
	private String icon;
	@ApiModelProperty(value = "游戏名称")
	private String gameName;
	@ApiModelProperty(value = "代币名称")
	private String coinName;
	@ApiModelProperty(value = "热度")
	private Long heat;
	@ApiModelProperty(value = "在玩人数")
	private Long players;
	@ApiModelProperty(value = "趋势:0不变 1上升 2下降 ")
	private Long trend;
	@ApiModelProperty(value = "成交额24H-RMB")
	private double volRmb;

	public double getVolRmb() {
		return volRmb;
	}

	public void setVolRmb(double volRmb) {
		this.volRmb = volRmb;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getCoinName() {
		return coinName;
	}

	public void setCoinName(String coinName) {
		this.coinName = coinName;
	}

	public Long getHeat() {
		return heat;
	}

	public void setHeat(Long heat) {
		this.heat = heat;
	}

	public Long getPlayers() {
		return players;
	}

	public void setPlayers(Long players) {
		this.players = players;
	}

	public Long getTrend() {
		return trend;
	}

	public void setTrend(Long trend) {
		this.trend = trend;
	}
}
