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
    public Long getid() {
        return this.id;
    }

    public void setid(Long id) {
        this.id = id;
    }
    public Long gettaskType() {
        return this.taskType;
    }

    public void settaskType(Long taskType) {
        this.taskType = taskType;
    }
    public String gettaskName() {
        return this.taskName;
    }

    public void settaskName(String taskName) {
        this.taskName = taskName;
    }
    public String gettaskPic() {
        return this.taskPic;
    }

    public void settaskPic(String taskPic) {
        this.taskPic = taskPic;
    }
    public Long getrewardType() {
        return this.rewardType;
    }

    public void setrewardType(Long rewardType) {
        this.rewardType = rewardType;
    }
    public String gettaskReward() {
        return this.taskReward;
    }

    public void settaskReward(String taskReward) {
        this.taskReward = taskReward;
    }
    public String gettaskCondition() {
        return this.taskCondition;
    }

    public void settaskCondition(String taskCondition) {
        this.taskCondition = taskCondition;
    }
    public Date getexpire() {
        return this.expire;
    }

    public void setexpire(Date expire) {
        this.expire = expire;
    }
    public Long gethidden() {
        return this.hidden;
    }

    public void sethidden(Long hidden) {
        this.hidden = hidden;
    }
    public String getmemo() {
        return this.memo;
    }

    public void setmemo(String memo) {
        this.memo = memo;
    }

}