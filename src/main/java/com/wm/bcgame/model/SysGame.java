package com.wm.bcgame.model;
import com.wm.bcgame.base.AbstractModel;


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
    private String name;
    //游戏图标
    private String icon;
    //代币
    private Long coinId;
    //描述
    private String description;
    //介绍
    private String introduce;
    //排序权重
    private Long pos;
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
    public String getname() {
        return this.name;
    }

    public void setname(String name) {
        this.name = name;
    }
    public String geticon() {
        return this.icon;
    }

    public void seticon(String icon) {
        this.icon = icon;
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
    public Long getpos() {
        return this.pos;
    }

    public void setpos(Long pos) {
        this.pos = pos;
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