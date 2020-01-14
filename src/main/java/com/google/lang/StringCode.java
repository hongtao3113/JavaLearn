package com.google.lang;

import java.io.UnsupportedEncodingException;

/**
 * @author wk
 * @Description:
 * @date 2020/1/13 10:47
 **/
public class StringCode {


    public static void main(String[] args) throws UnsupportedEncodingException {
        String name = "缂撳瓨浣跨敤鐨刴";

        byte[] b_iso88591 = name.getBytes("ISO8859-1");
        System.out.println(new String(b_iso88591, "UTF-8"));

        byte[] gbkBytes = name.getBytes("GBK");
        System.out.println(new String(gbkBytes, "UTF-8"));
        //缓存使用的m

        byte[] utfBytes = name.getBytes("UTF-8");
        System.out.println(new String(utfBytes, "UTF-8"));
    }
}
