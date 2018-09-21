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
    public Long getCoinType() {
        return this.coinType;
    }

    public void setCoinType(Long coinType) {
        this.coinType = coinType;
    }
    public Double getNum() {
        return this.num;
    }

    public void setNum(Double num) {
        this.num = num;
    }
    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public Double getNumLock() {
        return this.numLock;
    }

    public void setNumLock(Double numLock) {
        this.numLock = numLock;
    }
    public Long getCoinId() {
        return this.coinId;
    }

    public void setCoinId(Long coinId) {
        this.coinId = coinId;
    }

}