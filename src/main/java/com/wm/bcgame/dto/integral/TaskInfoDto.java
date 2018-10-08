package com.wm.bcgame.dto.integral;

import com.wm.bcgame.base.BaseDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author LZM
 * @description
 * @date 11:38 2018/9/21
 * @mondified
 **/

public class TaskInfoDto extends BaseDto{
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "任务ID")
	private Long id;
	@ApiModelProperty(value = "任务描述")
	private String taskName;
	@ApiModelProperty(value = "任务状态")
	private Long taskStatus;
	@ApiModelProperty(value = "奖励类型")
	private Long rewardType;
	@ApiModelProperty(value = "奖励数量")
	private Double reward;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Long getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(Long taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Long getRewardType() {
		return rewardType;
	}

	public void setRewardType(Long rewardType) {
		this.rewardType = rewardType;
	}

	public Double getReward() {
		return reward;
	}

	public void setReward(Double reward) {
		this.reward = reward;
	}
}
