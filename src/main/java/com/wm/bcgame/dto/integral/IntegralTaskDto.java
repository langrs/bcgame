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
	private List<TaskInfoDto> dailyTask;
	@ApiModelProperty(value = "成长任务列表")
	private List<TaskInfoDto> growupTask;
	@ApiModelProperty(value = "活动通知列表")
	private List<TaskNoiceDto> noticeTask;

	public List<TaskInfoDto> getDailyTask() {
		return dailyTask;
	}

	public void setDailyTask(List<TaskInfoDto> dailyTask) {
		this.dailyTask = dailyTask;
	}

	public List<TaskInfoDto> getGrowupTask() {
		return growupTask;
	}

	public void setGrowupTask(List<TaskInfoDto> growupTask) {
		this.growupTask = growupTask;
	}

	public List<TaskNoiceDto> getNoticeTask() {
		return noticeTask;
	}

	public void setNoticeTask(List<TaskNoiceDto> noticeTask) {
		this.noticeTask = noticeTask;
	}
}
