package com.wm.bcgame.model;
import com.wm.bcgame.base.AbstractModel;


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
    private String taskDate;
    //任务状态
    private Long taskStatus;
    //奖励类型
    private Long rewardType;
    //奖励
    private Double taskReward;
    //任务条件
    private String taskCondition;
    //
    private String memo;
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
    public Long getTaskId() {
        return this.taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
    public String getTaskDate() {
        return this.taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }
    public Long getTaskStatus() {
        return this.taskStatus;
    }

    public void setTaskStatus(Long taskStatus) {
        this.taskStatus = taskStatus;
    }
    public Long getRewardType() {
        return this.rewardType;
    }

    public void setRewardType(Long rewardType) {
        this.rewardType = rewardType;
    }
    public Double getTaskReward() {
        return this.taskReward;
    }

    public void setTaskReward(Double taskReward) {
        this.taskReward = taskReward;
    }
    public String getTaskCondition() {
        return this.taskCondition;
    }

    public void setTaskCondition(String taskCondition) {
        this.taskCondition = taskCondition;
    }
    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

}