package com.wm.bcgame.comm;

/**
 * @author LZM
 * @description
 * @date 17:07 2018/9/19
 * @mondified
 **/
public class BusinessException extends Exception {
	private static final long serialVersionUID = 1L;
	private Error error;

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}
}
