package com.wm.bcgame.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author LZM
 * @description K线图内容
 * @date 17:45 2018/9/11
 * @mondified
 **/
@ApiModel(value = "CoinKline",description = "币种K线图信息")
public class CoinKline implements Serializable{
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "统计时间--毫秒")
	private Long ts;
	@ApiModelProperty(value = "24H累计成交量--成交总金额")
	private double volRmb;
	@ApiModelProperty(value = "收盘价--人民币")
	private double closeRmb;
	@ApiModelProperty(value = "收盘价--美元")
	private double closeUsd;

	public Long getTs() {
		return ts;
	}

	public void setTs(Long ts) {
		this.ts = ts;
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

	public double getCloseUsdt() {
		return closeUsd;
	}

	public void setCloseUsdt(double closeUsdt) {
		this.closeUsd = closeUsdt;
	}
}
