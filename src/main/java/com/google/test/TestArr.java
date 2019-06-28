package com.google.test;

/**
 * 数组初始化
 * 
 * @author wk
 *
 */
public class TestArr {

	public static void main(String[] args) {
		int i = 0;
		int[] arr = new int[3];
		arr[2] = 0;
		for (; i <= 3; i++) {
			arr[i] = 0;
			System.out.println("hello");
		}

		@SuppressWarnings("unused")
		int a[] = new int[3];
		@SuppressWarnings("unused")
		int[] b = new int[3];
		@SuppressWarnings("unused")
		int aa[] = new int[] { 0 };
		@SuppressWarnings("unused")
		int bb[] = { 1, 2, };
		@SuppressWarnings("unused")
		int bb2[] = {};
	}

}
