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
	private String coinNo;
	@ApiModelProperty(value = "数据获取时间")
	private Long ts;
	@ApiModelProperty(value = "24H累计成交量--成交总金额RMB")
	private double volRmb;
	@ApiModelProperty(value = "收盘价--RMB")
	private double closeRmb;
	@ApiModelProperty(value = "收盘价--USD")
	private double closeUsd;
	@ApiModelProperty(value = "24H最高价 --RMB")
	private double highRmb;
	@ApiModelProperty(value = "24H最低价--RMB")
	private double lowRmb;
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
	@ApiModelProperty(value = "币种名称")
	private String name;
	@ApiModelProperty(value = "币种标题")
	private String title;
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

	public String getCoinNo() {
		return coinNo;
	}

	public void setCoinNo(String coinNo) {
		this.coinNo = coinNo;
	}

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

	public double getCloseUsd() {
		return closeUsd;
	}

	public void setCloseUsd(double closeUsd) {
		this.closeUsd = closeUsd;
	}

	public double getHighRmb() {
		return highRmb;
	}

	public void setHighRmb(double highRmb) {
		this.highRmb = highRmb;
	}

	public double getLowRmb() {
		return lowRmb;
	}

	public void setLowRmb(double lowRmb) {
		this.lowRmb = lowRmb;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
}
