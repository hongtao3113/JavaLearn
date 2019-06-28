package com.google.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ������
 * 
 * @author wk
 *
 */
public class DateUtil {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static void main(String[] args) {

		System.out.println("���ڲ�����");
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
	 * ����ת�ַ���
	 */
	public static void dateConvertToString() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		System.out.println("����ת�ַ�����" + sdf.format(date));

	}

	/**
	 * �ַ���ת����
	 */
	public static void stringConvertToDate() {

		String s = "2018-12-27 11:19:33";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		try {
			date = sdf.parse(s);
			System.out.println("�ַ���ת���ڣ�" + date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	/**
	 * ʱ���ת����
	 */
	public static void timestampConvertToDate() {
		System.out.println();
		// long timesTamp = new Date().getTime();
		long timesTamp = 1546790400000L;
		System.out.println("ʱ������ȣ�" + (timesTamp + "").length());
		Date date = new Date(timesTamp);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("ʱ���ת���ڣ�" + sdf.format(date));
		System.out.println("ʱ���ת���ڣ�" + date);

		String sdate = sdf.format(timesTamp);
		try {
			Date date2 = sdf.parse(sdate);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date2);
			System.out.println(""+calendar.get(Calendar.DAY_OF_MONTH));// ���������
		} catch (ParseException e) {
			e.printStackTrace();
		}
	

	}

	/**
	 * ����תʱ���
	 */
	public static void dateConvertToTimeStamp() {

		System.out.println("����תʱ�����" + new Date().getTime());

	}

	/**
	 * ʱ���ת����
	 */
	public static void timestampConvertDate() {
						 //1551082429172 599
		long timesTamp = 1551082429172L;
		Timestamp t = new Timestamp(timesTamp);
		System.out.println("timestampתDate:" + new Date(t.getTime()));

	}
	
	/**
	 * ��ȡ1���Ӻ��ʱ��
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
