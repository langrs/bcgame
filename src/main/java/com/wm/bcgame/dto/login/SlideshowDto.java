package com.wm.bcgame.dto.login;

import com.wm.bcgame.base.BaseDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author LZM
 * @description 轮播图
 * @date 11:10 2018/9/14
 * @mondified
 **/
public class SlideshowDto extends BaseDto{
	@ApiModelProperty(value = "轮播图名称")
	private String name;
	@ApiModelProperty(value = "轮播图描述")
	private String description;
	@ApiModelProperty(value = "轮播图地址")
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
