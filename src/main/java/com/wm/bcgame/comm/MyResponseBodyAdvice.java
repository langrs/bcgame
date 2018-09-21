package com.wm.bcgame.comm;

import com.wm.bcgame.dto.DataDto;
import com.wm.bcgame.dto.ResponseDto;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LZM
 * @description
 * @date 13:47 2018/9/20
 * @mondified
 **/
@ControllerAdvice(annotations = RestController.class)
public class MyResponseBodyAdvice implements ResponseBodyAdvice {
	@Override
	public boolean supports(MethodParameter methodParameter, Class aClass) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setStatus("200");
		if(o instanceof List) {
			DataDto<List> dataDto = new DataDto<>();
			dataDto.setDataList((List) o);
			responseDto.setData(dataDto);
		}else{
			responseDto.setData(o);
		}
		return responseDto;
	}
}
