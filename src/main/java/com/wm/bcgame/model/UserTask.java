package com.wm.bcgame.model;

import com.wm.bcgame.base.AbstractModel;

import java.util.Date;


/**
* 描述：
* @author lzm
* @date 2018/09/07
*/
public class UserTask extends AbstractModel {

    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private Long userId;
    //
    private Long taskId;
    //任务日期
    private Date taskDate;
    //任务状态
    private Long taskStatus;
    //奖励类型
    private Long rewardType;
    //奖励
    private Double reward;
    //任务条件
    private String taskCondition;
    //
    private String memo;
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
    public Long gettaskId() {
        return this.taskId;
    }

    public void settaskId(Long taskId) {
        this.taskId = taskId;
    }
    public Date gettaskDate() {
        return this.taskDate;
    }

    public void settaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }
    public Long gettaskStatus() {
        return this.taskStatus;
    }

    public void settaskStatus(Long taskStatus) {
        this.taskStatus = taskStatus;
    }
    public Long getrewardType() {
        return this.rewardType;
    }

    public void setrewardType(Long rewardType) {
        this.rewardType = rewardType;
    }
    public Double getreward() {
        return this.reward;
    }

    public void setreward(Double reward) {
        this.reward = reward;
    }
    public String gettaskCondition() {
        return this.taskCondition;
    }

    public void settaskCondition(String taskCondition) {
        this.taskCondition = taskCondition;
    }
    public String getmemo() {
        return this.memo;
    }

    public void setmemo(String memo) {
        this.memo = memo;
    }

}