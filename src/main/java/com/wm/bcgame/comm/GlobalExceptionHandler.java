package com.wm.bcgame.comm;

import com.wm.bcgame.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(BusinessException.class)
	@ResponseBody
	ResponseDto handleException(BusinessException e){
		ResponseDto responseDto  = new ResponseDto();
//		失败统一返回201
		responseDto.setStatus(Error.ERROR.getErrorCode());
		responseDto.setErrCode(e.getError().getErrorCode());
		responseDto.setErrMsg(e.getError().getErrorMessage());
		logger.error(e.getError().getErrorMessage());
		return responseDto;
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	ResponseDto handleException(Exception e){
		ResponseDto responseDto = new ResponseDto();
		responseDto.setStatus(Error.ERROR.getErrorCode());
		responseDto.setErrCode(Error.ERROR.getErrorCode());
		responseDto.setErrMsg(e.getMessage());
		logger.error(e.getMessage());
		return responseDto;
	}
}
