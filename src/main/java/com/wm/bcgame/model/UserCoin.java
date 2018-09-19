package com.wm.bcgame.model;
import com.wm.bcgame.base.AbstractModel;


/**
* 描述：
* @author lzm
* @date 2018/09/07
*/
public class UserCoin extends AbstractModel {

    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private Long userId;
    //币种类型
    private Long coinType;
    //数量
    private Double num;
    //金额
    private Double amount;
    //
    private Double numLock;
    //币种
    private Long coinId;
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
    public Long getcoinType() {
        return this.coinType;
    }

    public void setcoinType(Long coinType) {
        this.coinType = coinType;
    }
    public Double getnum() {
        return this.num;
    }

    public void setnum(Double num) {
        this.num = num;
    }
    public Double getamount() {
        return this.amount;
    }

    public void setamount(Double amount) {
        this.amount = amount;
    }
    public Double getnumLock() {
        return this.numLock;
    }

    public void setnumLock(Double numLock) {
        this.numLock = numLock;
    }
    public Long getcoinId() {
        return this.coinId;
    }

    public void setcoinId(Long coinId) {
        this.coinId = coinId;
    }

}