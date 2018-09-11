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
	private Number ts;
	@ApiModelProperty(value = "24H成交数--交易笔数")
	private int count;
	@ApiModelProperty(value = "24H成交额--币交易数量")
	private double amount;
	@ApiModelProperty(value = "24H累计成交量--成交总金额")
	private double vol;
	@ApiModelProperty(value = "开盘价")
	private double open;
	@ApiModelProperty(value = "收盘价")
	private double close;
	@ApiModelProperty(value = "24H最高价")
	private int high;
	@ApiModelProperty(value = "24H最低价")
	private int low;

	public Number getTs() {
		return ts;
	}

	public void setTs(Number ts) {
		this.ts = ts;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getVol() {
		return vol;
	}

	public void setVol(double vol) {
		this.vol = vol;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}
}
