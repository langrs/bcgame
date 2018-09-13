package com.wm.bcgame.dto;

import java.io.Serializable;

/**
 * @author LZM
 * @description
 * @date 17:43 2018/9/12
 * @mondified
 **/

public class CoinSingle implements Serializable{
	private static final long serialVersionUID = 1L;

	private double amount;
	private double open;
	private double close;
	private double high;
	private int count;
	private double low;
	private double vol;
	private Long ts;

	public Long getTs() {
		return ts;
	}

	public void setTs(Long ts) {
		this.ts = ts;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getVol() {
		return vol;
	}

	public void setVol(double vol) {
		this.vol = vol;
	}

}
