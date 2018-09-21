package com.wm.bcgame.comm;

/**
 * @author LZM
 * @description
 * @date 17:15 2018/9/19
 * @mondified
 **/
public enum Error {
	OK("200","ok"),
	ERROR("201","application error"),
	OPERATION_ERROR("202","system operation error"),
	VERSION_ERROR("203", "Version not support anyway"),
	TIME_OUT("204","Require time out,please call again"),
	NO_VALID_TOKEN("205", "Token is not valid");

	private final String errorCode;
	private final String errorMessage;
	//私有的构造函数
	private Error(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() { return errorCode; }

	public String getErrorMessage() { return errorMessage; }
}