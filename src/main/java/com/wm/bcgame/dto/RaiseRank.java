package com.wm.bcgame.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author LZM
 * @description 涨幅/跌幅榜
 * @date 13:49 2018/9/11
 * @mondified
 **/
@ApiModel(value = "RaiseRank",description = "币种涨/跌幅信息")
public class RaiseRank implements Serializable {

	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "币种")
	private String coinNo;
	@ApiModelProperty(value = "涨/跌幅%")
	private double rate;
	@ApiModelProperty(value = "24H累计成交量--成交总金额RMB")
	private double volRmb;
	@ApiModelProperty(value = "收盘价--USD")
	private double closeUsd;
	@ApiModelProperty(value = "成交价--RMB")
	private double closeRmb;
	@ApiModelProperty(value = "排名")
	private int rank;

	public String getCoinNo() {
		return coinNo;
	}

	public void setCoinNo(String coinNo) {
		this.coinNo = coinNo;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getVolRmb() {
		return volRmb;
	}

	public void setVolRmb(double volRmb) {
		this.volRmb = volRmb;
	}

	public double getCloseUsd() {
		return closeUsd;
	}

	public void setCloseUsd(double closeUsd) {
		this.closeUsd = closeUsd;
	}

	public double getCloseRmb() {
		return closeRmb;
	}

	public void setCloseRmb(double closeRmb) {
		this.closeRmb = closeRmb;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}
