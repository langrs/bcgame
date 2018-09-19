package com.wm.bcgame.taskService;

/**
 * @author LZM
 * @description
 * @date 18:53 2018/9/19
 * @mondified
 **/
public class CoreException extends Exception{
	private static final long serialVersionUID = 1L;
	private static String errMsg;

	public static String getErrMsg() {
		return errMsg;
	}

	public static void setErrMsg(String errMsg) {
		CoreException.errMsg = errMsg;
	}
}
