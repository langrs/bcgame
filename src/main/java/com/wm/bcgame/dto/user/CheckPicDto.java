package com.wm.bcgame.dto.user;

import com.wm.bcgame.base.BaseConstant;
import com.wm.bcgame.base.BaseDto;
import io.swagger.annotations.ApiParam;

/**
 * @author LZM
 * @description
 * @date 17:06 2018/9/21
 * @mondified
 **/
public class CheckPicDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	@ApiParam(value = "图片URL")
	private String url;
	@ApiParam(value = "身份码")
	private String validCode;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getValidCode() {
		return validCode;
	}

	public void setValidCode(String validCode) {
		this.validCode = validCode;
	}
}
