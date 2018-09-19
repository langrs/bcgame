package com.wm.bcgame.taskService;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LZM
 * @description 全局异常处理类
 * @date 17:01 2018/9/19
 * @mondified
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
//	@ExceptionHandler(CoreException.class)
//	@ResponseBody
//	String handleException(CoreException e){
//		return "-----lzm handler core-----Exception Deal!" + e.getErrMsg();
//	}
	@ExceptionHandler(Exception.class)

	@ResponseBody
	String handleException(BusinessException e){
		return "-----lzm handler business-----Exception Deal!" + e.getErrMsg();
	}
}
