package com.google.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期类
 * 
 * @author wk
 *
 */
public class DateUtil {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static void main(String[] args) {

		System.out.println("日期测试类");
		dateConvertToString();
		stringConvertToDate();
		timestampConvertToDate();
		dateConvertToTimeStamp();
		timestampConvertDate();
		getAfterOneMin();
		get();

	}
	
	public static void get() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		System.out.println(sdf.format(date)+date.getTime());
	}
	
	/**
	 * 日期转字符串
	 */
	public static void dateConvertToString() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		System.out.println("日期转字符串：" + sdf.format(date));

	}

	/**
	 * 字符串转日期
	 */
	public static void stringConvertToDate() {

		String s = "2018-12-27 11:19:33";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		try {
			date = sdf.parse(s);
			System.out.println("字符串转日期：" + date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 时间戳转日期
	 */
	public static void timestampConvertToDate() {
		System.out.println();
		// long timesTamp = new Date().getTime();
		long timesTamp = 1546790400000L;
		System.out.println("时间戳长度：" + (timesTamp + "").length());
		Date date = new Date(timesTamp);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("时间戳转日期：" + sdf.format(date));
		System.out.println("时间戳转日期：" + date);

		String sdate = sdf.format(timesTamp);
		try {
			Date date2 = sdf.parse(sdate);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date2);
			System.out.println(""+calendar.get(Calendar.DAY_OF_MONTH));// 今天的日期
		} catch (ParseException e) {
			e.printStackTrace();
		}
	

	}

	/**
	 * 日期转时间戳
	 */
	public static void dateConvertToTimeStamp() {

		System.out.println("日期转时间戳：" + new Date().getTime());

	}

	/**
	 * 时间戳转日期
	 */
	public static void timestampConvertDate() {
						 //1551082429172 599
		long timesTamp = 1551082429172L;
		Timestamp t = new Timestamp(timesTamp);
		System.out.println("timestamp转Date:" + new Date(t.getTime()));

	}
	
	/**
	 * 获取1分钟后的时间
	 */
	public static void getAfterOneMin() {
		Calendar nowTime = Calendar.getInstance();
		System.out.println(sdf.format(nowTime.getTime()));
		nowTime.add(Calendar.MINUTE, 1);
		//Calendar nowTime
		System.out.println(sdf.format(nowTime.getTime()));
		System.out.println();
	}
}
