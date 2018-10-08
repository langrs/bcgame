package com.wm.bcgame.dto.integral;

import com.wm.bcgame.base.BaseDto;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * @author LZM
 * @description
 * @date 14:37 2018/10/8
 * @mondified
 **/
public class DaibiDto extends BaseDto {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "代币编号")
	private String coinNo;
	@ApiModelProperty(value = "代币名称")
	private String name;
	@ApiModelProperty(value = "积分兑换代币的汇率：N个积分兑换1个代币")
	private String exchangeRate;
	@ApiModelProperty(value = "最后更新时间")
	private String lastModifiedTime;

	public String getCoinNo() {
		return coinNo;
	}

	public void setCoinNo(String coinNo) {
		this.coinNo = coinNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(String lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
}
