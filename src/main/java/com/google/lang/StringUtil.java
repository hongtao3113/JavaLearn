package com.google.lang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * �ַ�������
 * 
 * @author wk
 *
 */
public class StringUtil {

	public static void main(String[] args) {

//		String idcard = "140211199412243319";
//		int length = idcard.length();
//		StringBuffer newIdCard = new StringBuffer(idcard.substring(0, length / 2));
//		// ͨ��������ʽ�滻�ַ�
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
		String s1 = "��������ʯ��ׯ��Ӫ���֧��";
		String s2 = "ʯ��ׯ";
		System.out.println(s1.contains(s2));
		Integer cityFlag = s1.contains(s2) ? 0 : 1;
		System.out.println(cityFlag);
	}

	public static void replaceTest() {
		String s = "�ͻ����ã�$[compName]����Ӧ�̣������������������͹��У���ϵ�ˣ�$[userName]��$[userMobile]�����Ӹֹ�Ӧ��ƽ̨��";
		s = s.replace("$[compName]", "�Ӹּ������޹�˾").replace("$[userName]", "�ݹ���").replace("$[userMobile]", "13521201224");
		System.out.println(s);
	}

	/**
	 * ��ȡ�ַ���
	 */
	public static void subStringByPattern() {
		try {
			/* ����TXT�ļ� */
			String pathname = "D:\\citic523.log"; // ����·�������·�������ԣ������Ǿ���·����д���ļ�ʱ��ʾ���·��
			File filename = new File(pathname); // Ҫ��ȡ����·����input��txt�ļ�
			InputStreamReader reader = new InputStreamReader(new FileInputStream(filename), "GBK"); // ����һ������������reader
			BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������
			String line = "";
			line = br.readLine();
			if (line.contains("<action>DLSBAMAN</action>")) {
				System.out.print(getStrContainData(line, "<subAccNo>", "</subAccNo>") + "    ");
				System.out.print(getStrContainData(line, "<subAccNm>", "</subAccNm>"));
			}
			System.out.println();
			while (line != null) {
				line = br.readLine(); // һ�ζ���һ������
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
