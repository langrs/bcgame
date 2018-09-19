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
    public Long getid() {
        return this.id;
    }

    public void setid(Long id) {
        this.id = id;
    }
    public String getcoinNo() {
        return this.coinNo;
    }

    public void setcoinNo(String coinNo) {
        this.coinNo = coinNo;
    }
    public String getname() {
        return this.name;
    }

    public void setname(String name) {
        this.name = name;
    }
    public String gettitle() {
        return this.title;
    }

    public void settitle(String title) {
        this.title = title;
    }
    public String getdescription() {
        return this.description;
    }

    public void setdescription(String description) {
        this.description = description;
    }
    public String getdistributionAmt() {
        return this.distributionAmt;
    }

    public void setdistributionAmt(String distributionAmt) {
        this.distributionAmt = distributionAmt;
    }
    public String getturnoverAmt() {
        return this.turnoverAmt;
    }

    public void setturnoverAmt(String turnoverAmt) {
        this.turnoverAmt = turnoverAmt;
    }
    public String getmarketAmt() {
        return this.marketAmt;
    }

    public void setmarketAmt(String marketAmt) {
        this.marketAmt = marketAmt;
    }
    public String getmarketRank() {
        return this.marketRank;
    }

    public void setmarketRank(String marketRank) {
        this.marketRank = marketRank;
    }
    public String getissueDate() {
        return this.issueDate;
    }

    public void setissueDate(String issueDate) {
        this.issueDate = issueDate;
    }
    public String getwebsiteAddr() {
        return this.websiteAddr;
    }

    public void setwebsiteAddr(String websiteAddr) {
        this.websiteAddr = websiteAddr;
    }
    public String getwhitePaper() {
        return this.whitePaper;
    }

    public void setwhitePaper(String whitePaper) {
        this.whitePaper = whitePaper;
    }

}