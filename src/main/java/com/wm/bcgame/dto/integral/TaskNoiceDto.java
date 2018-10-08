package com.wm.bcgame.dto.integral;

import com.wm.bcgame.base.BaseDto;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author LZM
 * @description
 * @date 12:10 2018/9/21
 * @mondified
 **/
public class TaskNoiceDto extends BaseDto{
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "活动标题")
	private String title;
	@ApiModelProperty(value = "活动有效时间")
	private String noticeTime;
	@ApiModelProperty(value = "活动内容")
	private String description;
	@ApiModelProperty(value = "活动发布时间")
	private Date createTime;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNoticeTime() {
		return noticeTime;
	}

	public void setNoticeTime(String noticeTime) {
		this.noticeTime = noticeTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
