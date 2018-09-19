package com.wm.bcgame.taskService;

import org.junit.Test;

/**
 * @author LZM
 * @description
 * @date 17:16 2018/9/19
 * @mondified
 **/
public class TestError {
	@Test
	public void testEnum(){
		Error kk = Error.NO_TOKEN_FOUND;
		System.out.println(kk.errorMessage);
		System.out.println(kk.errorCode);
	}
	@Test
	public void testColor(){
		AllConstant.Color color = AllConstant.Color.RED;
//		System.out.println(color);
		AllConstant.ColorVal colorVal = AllConstant.ColorVal.BLACK;
		colorVal.name ="lzm";
		System.out.println(colorVal);
		System.out.println(colorVal.name);
		System.out.println(colorVal.val);
		System.out.println(colorVal.code);
	}
}
