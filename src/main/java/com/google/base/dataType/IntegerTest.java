package com.google.base.dataType;

/**
 * Integer类
 *
 * @author wk
 *
 */
public class IntegerTest {

	/**
	 * IntegerCache
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		Integer a = new Integer(3);
		Integer b = 3;
		int c = 3;
		System.out.println(a == b);//false
		System.out.println(a == c);//true

		Integer i1 = 100, i2 = 100, i3 = 150, i4 = 150;
		System.out.println(i1 == i2);// true
		System.out.println(i3 == i4);// false
		System.out.println(i3.equals(i4));//true

		Integer f1=-128,f2=-128,f3=127,f4=127,f5=128,f6=128;
		System.out.println(f1==f2);//ture
		System.out.println(f3==f4);//true
		System.out.println(f5==f6);//false
		//IntegerCache Integer缓存，-128~127
	}

}
