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
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Double getIntegral() {
        return this.integral;
    }

    public void setIntegral(Double integral) {
        this.integral = integral;
    }
    public Double getIntegralAll() {
        return this.integralAll;
    }

    public void setIntegralAll(Double integralAll) {
        this.integralAll = integralAll;
    }
    public Double getIntegralExchanged() {
        return this.integralExchanged;
    }

    public void setIntegralExchanged(Double integralExchanged) {
        this.integralExchanged = integralExchanged;
    }
    public Double getIntegralLocked() {
        return this.integralLocked;
    }

    public void setIntegralLocked(Double integralLocked) {
        this.integralLocked = integralLocked;
    }
    public Double getIntegralExpired() {
        return this.integralExpired;
    }

    public void setIntegralExpired(Double integralExpired) {
        this.integralExpired = integralExpired;
    }

}