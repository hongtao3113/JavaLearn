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
			System.out.println(classInfo.getField("s"));//只能获取public修饰的？
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		System.out.println(foo(6));
	}

	/**
	 * 递归调用，斐波那契数列
	 * @param i
	 * @return
	 */
	private static int foo(int i) {
		if (i < 2) {
			return i;
		}
		return foo(i - 1) + foo(i - 2);
		//f(7)=f(6)+f(5)=8+5
		//f(6)=f(5)+f(4)=5+3
		//f(5)=f(4)+f(3)=3+2
		//f(4)=f(3)+f(2)=2+1
		//f(3)=f(2)+f(1)=1+1
		//f(2)=f(1)+f(0)=1+0
	}

	public void test(){
		this.getClass();
	}
}
