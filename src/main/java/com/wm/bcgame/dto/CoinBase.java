package com.wm.bcgame.dto;

import java.io.Serializable;

/**
 * @author LZM
 * @description 币种
 * @date 17:39 2018/9/13
 * @mondified
 **/
public class CoinBase implements Serializable {
	private static final long serialVersionUID = 1L;
	//	币种
	private String coinNo;
	//	币种名称
	private String name;
	//	币成交数量
	private double amount;
	//	成交笔数
	private int count;
	//	币成交额
	private double vol;
	//	开盘价
	private double open;
	//	收盘价(最新价格)
	private double close;
	//	最高价--24H
	private double high;
	//	最低价--24H
	private double low;
	//	数据统计时间--毫秒
	private Long ts;
	//	涨幅%
	private double rate;
	//	涨点
	private double point;

	public String getCoinNo() {
		return coinNo;
	}

	public void setCoinNo(String coinNo) {
		this.coinNo = coinNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public Long getTs() {
		return ts;
	}

	public void setTs(Long ts) {
		this.ts = ts;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}
}
