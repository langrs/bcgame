package com.wm.bcgame.taskService;

/**
 * @author LZM
 * @description
 * @date 17:07 2018/9/19
 * @mondified
 **/
public class BusinessException extends Exception {
	private static final long serialVersionUID = 1L;
	private  String errMsg;

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
}
