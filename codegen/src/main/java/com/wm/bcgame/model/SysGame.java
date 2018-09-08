package com.wm.bcgame.model;
import com.wm.bcgame.base.AbstractModel;
import java.util.Date;




/**
* 描述：
* @author lzm
* @date 2018/09/07
*/
public class SysGame extends AbstractModel {

    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //游戏名称
    private String gameName;
    //代币
    private Long coinId;
    //描述
    private String description;
    //介绍
    private String introduce;
    //排序权重
    private Long position;
    //热度
    private Long heat;
    //参与人数
    private Long players;
    //趋势
    private Long trend;
    //备注说明
    private String memo;
///////////////////////////////////////////////////////////////
    public Long getid() {
        return this.id;
    }

    public void setid(Long id) {
        this.id = id;
    }
    public String getgameName() {
        return this.gameName;
    }

    public void setgameName(String gameName) {
        this.gameName = gameName;
    }
    public Long getcoinId() {
        return this.coinId;
    }

    public void setcoinId(Long coinId) {
        this.coinId = coinId;
    }
    public String getdescription() {
        return this.description;
    }

    public void setdescription(String description) {
        this.description = description;
    }
    public String getintroduce() {
        return this.introduce;
    }

    public void setintroduce(String introduce) {
        this.introduce = introduce;
    }
    public Long getposition() {
        return this.position;
    }

    public void setposition(Long position) {
        this.position = position;
    }
    public Long getheat() {
        return this.heat;
    }

    public void setheat(Long heat) {
        this.heat = heat;
    }
    public Long getplayers() {
        return this.players;
    }

    public void setplayers(Long players) {
        this.players = players;
    }
    public Long gettrend() {
        return this.trend;
    }

    public void settrend(Long trend) {
        this.trend = trend;
    }
    public String getmemo() {
        return this.memo;
    }

    public void setmemo(String memo) {
        this.memo = memo;
    }

}