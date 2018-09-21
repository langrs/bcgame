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
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public Long getCoinId() {
        return this.coinId;
    }

    public void setCoinId(Long coinId) {
        this.coinId = coinId;
    }
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getIntroduce() {
        return this.introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
    public Long getPos() {
        return this.pos;
    }

    public void setPos(Long pos) {
        this.pos = pos;
    }
    public Long getHeat() {
        return this.heat;
    }

    public void setHeat(Long heat) {
        this.heat = heat;
    }
    public Long getPlayers() {
        return this.players;
    }

    public void setPlayers(Long players) {
        this.players = players;
    }
    public Long getTrend() {
        return this.trend;
    }

    public void setTrend(Long trend) {
        this.trend = trend;
    }
    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

}