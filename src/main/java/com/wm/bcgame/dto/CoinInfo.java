package com.wm.bcgame.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author LZM
 * @description 币种详细信息
 * @date 15:45 2018/9/11
 * @mondified
 **/
@ApiModel(value = "CoinInfo",description = "币种信息")
public class CoinInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "币种")
	private String coin;
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
	////////////////////////////////////////////
	@ApiModelProperty(value = "日K线--5min")
	private List<CoinKline> kLineDay;
	@ApiModelProperty(value = "周K线--30min")
	private List<CoinKline> kLineWeek;
	@ApiModelProperty(value = "月K线--60min")
	private List<CoinKline> kLineMonth;
	@ApiModelProperty(value = "年K线--1day")
	private List<CoinKline> kLineYear;

	////////////////////////////////////////////////
	@ApiModelProperty(value = "币种标题")
	private String coinTitle;
	@ApiModelProperty(value = "币种描述")
	private String description;
	@ApiModelProperty(value = "发行总量")
	private String distributionAmt;
	@ApiModelProperty(value = "流通总量")
	private String turnoverAmt;
	@ApiModelProperty(value = "流通市值")
	private String marketAmt;
	@ApiModelProperty(value = "市值排名")
	private String marketRank;
	@ApiModelProperty(value = "发行时间")
	private String issueDate;
	@ApiModelProperty(value = "官网地址")
	private String websiteAddr;
	@ApiModelProperty(value = "白皮书")
	private String whitePaper;

	public String getCoin() {
		return coin;
	}

	public void setCoin(String coin) {
		this.coin = coin;
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

	public String getCoinTitle() {
		return coinTitle;
	}

	public void setCoinTitle(String coinTitle) {
		this.coinTitle = coinTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDistributionAmt() {
		return distributionAmt;
	}

	public void setDistributionAmt(String distributionAmt) {
		this.distributionAmt = distributionAmt;
	}

	public String getTurnoverAmt() {
		return turnoverAmt;
	}

	public void setTurnoverAmt(String turnoverAmt) {
		this.turnoverAmt = turnoverAmt;
	}

	public String getMarketAmt() {
		return marketAmt;
	}

	public void setMarketAmt(String marketAmt) {
		this.marketAmt = marketAmt;
	}

	public String getMarketRank() {
		return marketRank;
	}

	public void setMarketRank(String marketRank) {
		this.marketRank = marketRank;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getWebsiteAddr() {
		return websiteAddr;
	}

	public void setWebsiteAddr(String websiteAddr) {
		this.websiteAddr = websiteAddr;
	}

	public String getWhitePaper() {
		return whitePaper;
	}

	public void setWhitePaper(String whitePaper) {
		this.whitePaper = whitePaper;
	}

	public List<CoinKline> getkLineDay() {
		return kLineDay;
	}

	public void setkLineDay(List<CoinKline> kLineDay) {
		this.kLineDay = kLineDay;
	}

	public List<CoinKline> getkLineWeek() {
		return kLineWeek;
	}

	public void setkLineWeek(List<CoinKline> kLineWeek) {
		this.kLineWeek = kLineWeek;
	}

	public List<CoinKline> getkLineMonth() {
		return kLineMonth;
	}

	public void setkLineMonth(List<CoinKline> kLineMonth) {
		this.kLineMonth = kLineMonth;
	}

	public List<CoinKline> getkLineYear() {
		return kLineYear;
	}

	public void setkLineYear(List<CoinKline> kLineYear) {
		this.kLineYear = kLineYear;
	}

}
