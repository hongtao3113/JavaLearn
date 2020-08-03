package com.google.encryption;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5工具类
 * @author iuv
 *
 */
public class MD5Util {
	
	/**
	 * 生成md5字符串（32位）
	 * @param inStr
	 * @return
	 */
	public static String digest(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];

		byte[] md5Bytes = md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}

		return hexValue.toString();
	}

	/**
	 * MD5加密算法16位大写
	 */
	public static String getMD516Up(String pwd, boolean isUpper, Integer bit) {
		String md5 = new String();
		try {
			// 创建加密对象
			MessageDigest md = MessageDigest.getInstance("md5");
			if (bit == 64) {
				BASE64Encoder bw = new BASE64Encoder();
				String bsB64 = bw.encode(md.digest(pwd.getBytes("utf-8")));
				md5 = bsB64;
			} else {
				// 计算MD5函数
				md.update(pwd.getBytes());
				byte b[] = md.digest();
				int i;
				StringBuffer sb = new StringBuffer("");
				for (int offset = 0; offset < b.length; offset++) {
					i = b[offset];
					if (i < 0)
						i += 256;
					if (i < 16)
						sb.append("0");
					sb.append(Integer.toHexString(i));
				}
				md5 = sb.toString();
				if(bit == 16) {
					//截取32位md5为16位
					String md16 = md5.substring(8, 24).toString();
					md5 = md16;
					if (isUpper)
						md5 = md5.toUpperCase();
					return md5;
				}
			}
			//转换成大写
			if (isUpper)
				md5 = md5.toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("md5加密抛出异常！");
		}

		return md5;
	}

	/**
	 * md5 32为大写加密
	 */
	public static String getMD532Up(String text){

		try {
			MessageDigest digest = MessageDigest.getInstance("md5");
			byte[] result = digest.digest(text.getBytes());
			StringBuilder sb =new StringBuilder();
			for(byte b:result){
				int number = b&0xff;
				String hex = Integer.toHexString(number);
				if(hex.length() == 1){
					sb.append("0"+hex);
				}else{
					sb.append(hex);
				}
			}
			return sb.toString().toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return "" ;
	}

	public static void main(String[] args) {
		System.out.println(digest("luffy1001"));
		System.out.println(getMD516Up("luffy1001",false,16));
	}

}


