package com.wm.bcgame.model;
import com.wm.bcgame.base.AbstractModel;


/**
* 描述：
* @author lzm
* @date 2018/09/07
*/
public class SysCoin extends AbstractModel {

    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //编码
    private String coinNo;
    //币种名称
    private String name;
    //标题
    private String title;
    //描述
    private String description;
    //发行总量
    private String distributionAmt;
    //流通总量
    private String turnoverAmt;
    //流通市值
    private String marketAmt;
    //市值排名
    private String marketRank;
    //发行时间
    private String issueDate;
    //官网地址
    private String websiteAddr;
    //白皮书
    private String whitePaper;
///////////////////////////////////////////////////////////////
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCoinNo() {
        return this.coinNo;
    }

    public void setCoinNo(String coinNo) {
        this.coinNo = coinNo;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDistributionAmt() {
        return this.distributionAmt;
    }

    public void setDistributionAmt(String distributionAmt) {
        this.distributionAmt = distributionAmt;
    }
    public String getTurnoverAmt() {
        return this.turnoverAmt;
    }

    public void setTurnoverAmt(String turnoverAmt) {
        this.turnoverAmt = turnoverAmt;
    }
    public String getMarketAmt() {
        return this.marketAmt;
    }

    public void setMarketAmt(String marketAmt) {
        this.marketAmt = marketAmt;
    }
    public String getMarketRank() {
        return this.marketRank;
    }

    public void setMarketRank(String marketRank) {
        this.marketRank = marketRank;
    }
    public String getIssueDate() {
        return this.issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
    public String getWebsiteAddr() {
        return this.websiteAddr;
    }

    public void setWebsiteAddr(String websiteAddr) {
        this.websiteAddr = websiteAddr;
    }
    public String getWhitePaper() {
        return this.whitePaper;
    }

    public void setWhitePaper(String whitePaper) {
        this.whitePaper = whitePaper;
    }

}