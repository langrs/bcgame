package com.wm.bcgame.dto.integral;

import com.wm.bcgame.base.BaseDto;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author LZM
 * @description
 * @date 13:45 2018/9/21
 * @mondified
 **/
public class IntegralTaskDto extends BaseDto {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "每日任务列表")
	private List<TaskInfoDao> dailyTask;
	@ApiModelProperty(value = "成长任务列表")
	private List<TaskInfoDao> growupTask;
	@ApiModelProperty(value = "活动通知列表")
	private List<TaskNoiceDao> noticeTask;

	public List<TaskInfoDao> getDailyTask() {
		return dailyTask;
	}

	public void setDailyTask(List<TaskInfoDao> dailyTask) {
		this.dailyTask = dailyTask;
	}

	public List<TaskInfoDao> getGrowupTask() {
		return growupTask;
	}

	public void setGrowupTask(List<TaskInfoDao> growupTask) {
		this.growupTask = growupTask;
	}

	public List<TaskNoiceDao> getNoticeTask() {
		return noticeTask;
	}

	public void setNoticeTask(List<TaskNoiceDao> noticeTask) {
		this.noticeTask = noticeTask;
	}
}
