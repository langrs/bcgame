package com.wm.bcgame.model;

import com.wm.bcgame.base.AbstractModel;

import java.util.Date;


/**
* 描述：
* @author lzm
* @date 2018/09/07
*/
public class SysTask extends AbstractModel {

    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //任务类型
    private Long taskType;
    //任务描述
    private String taskName;
    //任务图标
    private String taskPic;
    //回报类型
    private Long rewardType;
    //任务回报
    private String taskReward;
    //任务条件
    private String taskCondition;
    //截止日期
    private Date expire;
    //是否显示
    private Long hidden;
    //备注描述
    private String memo;
///////////////////////////////////////////////////////////////
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getTaskType() {
        return this.taskType;
    }

    public void setTaskType(Long taskType) {
        this.taskType = taskType;
    }
    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public String getTaskPic() {
        return this.taskPic;
    }

    public void setTaskPic(String taskPic) {
        this.taskPic = taskPic;
    }
    public Long getRewardType() {
        return this.rewardType;
    }

    public void setRewardType(Long rewardType) {
        this.rewardType = rewardType;
    }
    public String getTaskReward() {
        return this.taskReward;
    }

    public void setTaskReward(String taskReward) {
        this.taskReward = taskReward;
    }
    public String getTaskCondition() {
        return this.taskCondition;
    }

    public void setTaskCondition(String taskCondition) {
        this.taskCondition = taskCondition;
    }
    public Date getExpire() {
        return this.expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }
    public Long getHidden() {
        return this.hidden;
    }

    public void setHidden(Long hidden) {
        this.hidden = hidden;
    }
    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

}