package com.wm.bcgame.dto.login;

import com.wm.bcgame.base.BaseDto;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author LZM
 * @description 公告消息
 * @date 11:27 2018/9/14
 * @mondified
 **/
public class UserNoticeDto extends BaseDto {
	@ApiModelProperty(value = "公告ID")
	private Long id;
	@ApiModelProperty(value = "公告标题")
	private String title;
	@ApiModelProperty(value = "公告正文")
	private String description;
	@ApiModelProperty(value = "公告时间")
	private Date createTime;
	@ApiModelProperty(value = "公告状态:1已读 0未读")
	private int noticeStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getNoticeStatus() {
		return noticeStatus;
	}

	public void setNoticeStatus(int noticeStatus) {
		this.noticeStatus = noticeStatus;
	}
}
