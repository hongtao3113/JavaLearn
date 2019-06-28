package com.google.math;

import java.math.BigDecimal;

public class BigDecimalTest {

	public static void main(String[] args) {

		System.out.println(new BigDecimal(100));
		System.out.println(new BigDecimal(0.3));
		comparativeSize();
		test();

	}

	public static void comparativeSize() {

		BigDecimal b1 = new BigDecimal(100);
		BigDecimal b2 = new BigDecimal(200);
		if (b1.compareTo(b2) == 0) {
			System.out.println("b1等于b2");
		}
		if (b1.compareTo(b2) == 1) {
			System.out.println("b1大于b2");
		}
		if (b1.compareTo(b2) == -1) {
			System.out.println("b1小于b2");
		}
		if (b1.compareTo(b2) <= 0) {
			System.out.println("b1小于或等于b2");
		}

	}

	public static void test() {
		String sellDays = "100";
		BigDecimal rateYear = new BigDecimal(0.6).multiply(DataUtil.bigDecimalUtil(360))
				.divide(DataUtil.bigDecimalUtil(sellDays), BigDecimal.ROUND_HALF_UP, 6);
		System.out.println(rateYear);

	}

}
