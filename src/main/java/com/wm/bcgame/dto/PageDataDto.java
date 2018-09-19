package com.wm.bcgame.dto;

import com.wm.bcgame.base.BaseDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author LZM
 * @description
 * @date 17:29 2018/9/15
 * @mondified
 **/
public class PageDataDto<T> extends BaseDto {
	@ApiModelProperty(value = "返回数据列表")
	private T dataList;
	@ApiModelProperty(value = "总页数")
	private Long totalPage;
	@ApiModelProperty(value = "当前页")
	private Long currentPage;
	@ApiModelProperty(value = "每页条数")
	private Long pageSize;
///////////////////////////////////////////

	public T getDataList() {
		return dataList;
	}

	public void setDataList(T dataList) {
		this.dataList = dataList;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public Long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}
}
