package com.wm.bcgame.comm;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author LZM
 * @description
 * @date 17:58 2018/9/21
 * @mondified
 **/
public class DateUtil {
//	获取当天日期，格式为yyyy/mm/dd
	public static String getTodayStr(Date date){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/mm/dd");
		return sf.format(date);
	}
//	获取第二天日期,格式为yyyy/mm/dd
	public static String getNextDayStr(Date date){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/mm/dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR,1);
		return sf.format(calendar.getTime());
	}
}
