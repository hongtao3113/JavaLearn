package com.google.test;

@SuppressWarnings("unused")
public class Test {
	public static String s = "2222";
	static {
		String s = "2";
	}

	public static void main(String[] args) {
		Class<Test> classInfo = Test.class;
		try {

			System.out.println(classInfo.getField("s"));//ֻ�ܻ�ȡpublic���εģ�
			Object object = new Object();

		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

}
