package com.google.algorithm.coding;

/**
 * N个数相加 1 2 3 4 5 n……
 * 
 * @author wk
 *
 */
public class NumberSum {

	public static void main(String[] args) {
		int length = 2;
		test1(length);// 时间复杂度O(n)
		test2(length);// O(1)
		test3(length);
		test4(length);
	}

	public static void test1(int length) {
		long t1 = System.nanoTime();
		int sum = 0;
		for (int i = 1; i <= length; i++) {
			sum = sum + i;
		}
		System.out.println(sum);
		System.out.println(System.nanoTime() - t1);
	}

	public static void test2(int n) {
		long t1 = System.nanoTime();
		System.out.println(n * (n + 1) / 2);
		System.out.println(System.nanoTime() - t1);
	}

	public static void test3(int n) {
		long t1 = System.nanoTime();
		System.out.println(n * (n + 1));
		System.out.println(System.nanoTime() - t1);
	}

	public static void test4(int n) {
		long t1 = System.nanoTime();
		int sum = 0;
		for (int i = 2; i <= 2 * n; i = i + 2) {
			sum = sum+i;
		}
		System.out.println(sum);
		System.out.println(System.nanoTime() - t1);
	}
}
