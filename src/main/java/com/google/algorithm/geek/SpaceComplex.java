package com.google.algorithm.geek;

/**
 * �ռ临�Ӷȷ���
 * 
 * @author wk
 *
 */
public class SpaceComplex {

	public static void main(String[] args) {
		test(10);
	}

	private static void test(int n) {
		int i = 0;
		int[] arr = new int[n];
		for (int j = i; j < n; j++) {
			arr[j] = j;
		}
		
		for (int j = i; j < n; j++) {
			System.out.println(arr[j]);
		}
	}

}
