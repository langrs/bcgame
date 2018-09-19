package com.wm.bcgame.taskService;

/**
 * @author LZM
 * @description
 * @date 17:24 2018/9/19
 * @mondified
 **/
public class AllConstant
{
	public static enum Color{
		RED,BLACK,WHITE,GREEN;
	}

	public static enum ColorVal{

		RED(1,"red","0001"),BLACK(2,"black","0002"),WHITE(3,"white","0003"),GREEN(4,"green","0004");

		public int val;
		public String name;
		public String code;
		ColorVal(int val,String name,String code){
			this.val =val;
			this.name = name;
			this.code = code;
		}

//		public String getCode() {
//			return code;
//		}
//
//		public int getVal() {
//			return val;
//		}
//
//
//		public String getName() {
//			return name;
//		}

	}

}
