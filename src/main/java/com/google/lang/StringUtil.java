package com.google.lang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具
 * 
 * @author wk
 *
 */
public class StringUtil {

	public static void main(String[] args) {

//		String idcard = "140211199412243319";
//		int length = idcard.length();
//		StringBuffer newIdCard = new StringBuffer(idcard.substring(0, length / 2));
//		// 通过正则表达式替换字符
//		newIdCard.append(idcard.substring(length / 2).replaceAll(".", "*"));
//		System.out.println(newIdCard);
//		isContain();
//		replaceTest();
//		System.out.println(getStrContainData("123//45","//",""));
		// subStringByPattern();
		@SuppressWarnings("unused")
		String s ="scf-TX1904170100";
		test();

	}

	public static void isContain() {
		String s1 = "中信银行石家庄翟营大街支行";
		String s2 = "石家庄";
		System.out.println(s1.contains(s2));
		Integer cityFlag = s1.contains(s2) ? 0 : 1;
		System.out.println(cityFlag);
	}

	public static void replaceTest() {
		String s = "客户您好，$[compName]（供应商）铁信融资意向已推送贵行，联系人：$[userName]，$[userMobile]。【河钢供应链平台】";
		s = s.replace("$[compName]", "河钢集团有限公司").replace("$[userName]", "戚国华").replace("$[userMobile]", "13521201224");
		System.out.println(s);
	}

	/**
	 * 截取字符串
	 */
	public static void subStringByPattern() {
		try {
			/* 读入TXT文件 */
			String pathname = "D:\\citic523.log"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
			File filename = new File(pathname); // 要读取以上路径的input。txt文件
			InputStreamReader reader = new InputStreamReader(new FileInputStream(filename), "GBK"); // 建立一个输入流对象reader
			BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
			String line = "";
			line = br.readLine();
			if (line.contains("<action>DLSBAMAN</action>")) {
				System.out.print(getStrContainData(line, "<subAccNo>", "</subAccNo>") + "    ");
				System.out.print(getStrContainData(line, "<subAccNm>", "</subAccNm>"));
			}
			System.out.println();
			while (line != null) {
				line = br.readLine(); // 一次读入一行数据
				if (line != null) {
					if (line.contains("<action>DLSBAMAN</action>")) {
						System.out.print(getStrContainData(line, "<subAccNo>", "</subAccNo>") + "    ");
						System.out.print(getStrContainData(line, "<subAccNm>", "</subAccNm>"));
						System.out.println();
					}
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getStrContainData(String str, String start, String end) {
		String s = null;
		Pattern p = Pattern.compile(start + "(.*)" + end);
		Matcher m = p.matcher(str);
		while (m.find()) {
			s = m.group(1);
		}
		return s;
	}
	public static void test() {
		String receNo ="";
		String use = "scf-TX1904170100-|TX1904170100|";
		if(use.contains("scf")){
			receNo =getStrContainData(use,"|","|");
		}else{
			receNo =getStrContainData(use,"-","");
		}
		System.out.println(receNo);
	}
}
