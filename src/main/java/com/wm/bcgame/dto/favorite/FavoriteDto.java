package com.wm.bcgame.dto.favorite;

import com.wm.bcgame.base.BaseDto;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * @author LZM
 * @description 用户收藏
 * @date 10:01 2018/9/15
 * @mondified
 **/
public class FavoriteDto extends BaseDto {
	@ApiModelProperty(value = "收藏ID")
	private Long id;
	@ApiModelProperty(value = "游戏收藏名称")
	private String gameName;
	@ApiModelProperty(value = "币种编码")
	private String coinNo;
	@ApiModelProperty(value = "币种收藏名称")
	private String coinName;
	@ApiModelProperty(value = "游戏图标URL")
	private String icon;
	@ApiModelProperty(value = "成交额24H--RMB")
	private double volRmb;
	@ApiModelProperty(value = "收盘价--RMB")
	private double closeRmb;
	@ApiModelProperty(value = "收盘价--USD")
	private double closeUsd;
	@ApiModelProperty(value = "涨幅%")
	private double rate;
	@ApiModelProperty(value = "活跃人数")
	private Long players;

	public String getCoinNo() {
		return coinNo;
	}

	public void setCoinNo(String coinNo) {
		this.coinNo = coinNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public double getVolRmb() {
		return volRmb;
	}

	public void setVolRmb(double volRmb) {
		this.volRmb = volRmb;
	}

	public double getCloseRmb() {
		return closeRmb;
	}

	public void setCloseRmb(double closeRmb) {
		this.closeRmb = closeRmb;
	}

	public double getCloseUsd() {
		return closeUsd;
	}

	public void setCloseUsd(double closeUsd) {
		this.closeUsd = closeUsd;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public Long getPlayers() {
		return players;
	}

	public void setPlayers(Long players) {
		this.players = players;
	}
}
