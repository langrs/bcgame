package com.wm.bcgame.model;
import com.wm.bcgame.base.AbstractModel;


/**
* 描述：
* @author lzm
* @date 2018/09/07
*/
public class UserIntegral extends AbstractModel {

    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private Long userId;
    //可用积分
    private Double integral;
    //总产生积分
    private Double integralAll;
    //兑换积分
    private Double integralExchanged;
    //锁定积分
    private Double integralLocked;
    //过期积分
    private Double integralExpired;
///////////////////////////////////////////////////////////////
    public Long getid() {
        return this.id;
    }

    public void setid(Long id) {
        this.id = id;
    }
    public Long getuserId() {
        return this.userId;
    }

    public void setuserId(Long userId) {
        this.userId = userId;
    }
    public Double getintegral() {
        return this.integral;
    }

    public void setintegral(Double integral) {
        this.integral = integral;
    }
    public Double getintegralAll() {
        return this.integralAll;
    }

    public void setintegralAll(Double integralAll) {
        this.integralAll = integralAll;
    }
    public Double getintegralExchanged() {
        return this.integralExchanged;
    }

    public void setintegralExchanged(Double integralExchanged) {
        this.integralExchanged = integralExchanged;
    }
    public Double getintegralLocked() {
        return this.integralLocked;
    }

    public void setintegralLocked(Double integralLocked) {
        this.integralLocked = integralLocked;
    }
    public Double getintegralExpired() {
        return this.integralExpired;
    }

    public void setintegralExpired(Double integralExpired) {
        this.integralExpired = integralExpired;
    }

}