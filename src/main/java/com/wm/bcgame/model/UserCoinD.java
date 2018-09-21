package com.wm.bcgame.model;
import com.wm.bcgame.base.AbstractModel;


/**
* 描述：
* @author lzm
* @date 2018/09/07
*/
public class UserCoinD extends AbstractModel {

    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //用户
    private Long userId;
    //币种
    private Long coinId;
    //操作类型
    private Long operationType;
    //操作数量
    private Double num;
    //操作金额
    private Double amout;
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
    public Long getCoinId() {
        return this.coinId;
    }

    public void setCoinId(Long coinId) {
        this.coinId = coinId;
    }
    public Long getOperationType() {
        return this.operationType;
    }

    public void setOperationType(Long operationType) {
        this.operationType = operationType;
    }
    public Double getNum() {
        return this.num;
    }

    public void setNum(Double num) {
        this.num = num;
    }
    public Double getAmout() {
        return this.amout;
    }

    public void setAmout(Double amout) {
        this.amout = amout;
    }

}