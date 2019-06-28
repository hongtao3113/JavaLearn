package com.google.util;

import java.security.SecureRandom;
import java.util.Random;

/**
 * String常用方法
 * 
 * @author wk
 *
 */
public class StringUtil {

	public static void main(String[] args) {

		System.out.println("hello");
		getNonce_str();
		getString();
	}

	public static void getNonce_str() {

		final String SYMBOLS = "0123456789";
		Random RANDOM = new SecureRandom();
		// 如果需要4位，那 new char[4] 即可，其他位数同理可得
		char[] nonceChars = new char[4];

		for (int index = 0; index < nonceChars.length; ++index) {
			nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
		}

		System.out.println(new String(nonceChars));

	}
	
	public static void getString() {
		String s="1234666666";
		System.out.println(s.substring(s.length()-6));
	}
}
