package com.wm.bcgame.model;
import com.wm.bcgame.base.AbstractModel;


/**
* 描述：
* @author lzm
* @date 2018/09/07
*/
public class UserIntegralD extends AbstractModel {

    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private Long userId;
    //操作类型
    private Long operationType;
    //类型细分
    private Long operationAttr;
    //
    private Double integral;
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
    public Long getoperationType() {
        return this.operationType;
    }

    public void setoperationType(Long operationType) {
        this.operationType = operationType;
    }
    public Long getoperationAttr() {
        return this.operationAttr;
    }

    public void setoperationAttr(Long operationAttr) {
        this.operationAttr = operationAttr;
    }
    public Double getintegral() {
        return this.integral;
    }

    public void setintegral(Double integral) {
        this.integral = integral;
    }

}