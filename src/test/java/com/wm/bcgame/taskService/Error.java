package com.wm.bcgame.taskService;

/**
 * @author LZM
 * @description
 * @date 17:15 2018/9/19
 * @mondified
 **/
public enum Error {
	NO_TOKEN_FOUND(1, "No token found"),
	NO_VALID_TOKEN(2, "Token is not valid");

	public final int errorCode;
	public final String errorMessage;

	private Error(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() { return errorCode; }

	public String getErrorMessage() { return errorMessage; }
}