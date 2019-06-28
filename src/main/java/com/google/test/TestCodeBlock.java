package com.google.test;

/**
 * 
 * ´úÂë¿é
 * 
 * @author wk
 *
 */
public class TestCodeBlock {

	static int x = 10;
	static {
		x = x + 5;
	}

	public static void main(String[] args) {
		System.out.println("x=" + x);// Êä³ö5
	}

	static {
		x /= 3;
	}
}
