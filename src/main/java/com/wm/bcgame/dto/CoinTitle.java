package com.wm.bcgame.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author LZM
 * @description 币种基本信息表
 * @date 9:47 2018/9/13
 * @mondified
 **/
public class CoinTitle implements Serializable{
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "币种")
	private String coinNo;
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
