package com.wm.bcgame.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author LZM
 * @description 涨幅/跌幅榜
 * @date 13:49 2018/9/11
 * @mondified
 **/
public class RaiseRank implements Serializable {

	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "币种")
	private String coin;
	@ApiModelProperty(value = "计价货币")
	private String basePrice;
	@ApiModelProperty(value = "涨/跌幅%")
	private double rate;
	@ApiModelProperty(value = "成交额")
	private double vol;
	@ApiModelProperty(value = "成交量")
	private double count;
	@ApiModelProperty(value = "开盘价")
	private double open;
	@ApiModelProperty(value = "收盘价")
	private double close;
	@ApiModelProperty(value = "成交价--人民币计价")
	private double closeRmb;
	@ApiModelProperty(value = "排名")
	private int rank;

	public String getCoin() {
		return coin;
	}

	public void setCoin(String coin) {
		this.coin = coin;
	}

	public String getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getVol() {
		return vol;
	}

	public void setVol(double vol) {
		this.vol = vol;
	}

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
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
