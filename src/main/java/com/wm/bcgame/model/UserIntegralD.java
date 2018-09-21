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
    public Long getOperationType() {
        return this.operationType;
    }

    public void setOperationType(Long operationType) {
        this.operationType = operationType;
    }
    public Long getOperationAttr() {
        return this.operationAttr;
    }

    public void setOperationAttr(Long operationAttr) {
        this.operationAttr = operationAttr;
    }
    public Double getIntegral() {
        return this.integral;
    }

    public void setIntegral(Double integral) {
        this.integral = integral;
    }

}