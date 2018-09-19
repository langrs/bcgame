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
    public Long getcoinId() {
        return this.coinId;
    }

    public void setcoinId(Long coinId) {
        this.coinId = coinId;
    }
    public Long getoperationType() {
        return this.operationType;
    }

    public void setoperationType(Long operationType) {
        this.operationType = operationType;
    }
    public Double getnum() {
        return this.num;
    }

    public void setnum(Double num) {
        this.num = num;
    }
    public Double getamout() {
        return this.amout;
    }

    public void setamout(Double amout) {
        this.amout = amout;
    }

}