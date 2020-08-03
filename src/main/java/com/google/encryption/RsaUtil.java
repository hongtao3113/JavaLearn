package com.google.encryption;

import sun.misc.BASE64Decoder;

import java.io.IOException;

/**
 * @author wk
 * @Description:
 * @date 2020/1/15 11:59
 **/
public class RsaUtil {

    public static void main(String[] args) throws IOException {

        String s = "SGVsbG8=";
        byte[] bytes = new BASE64Decoder().decodeBuffer(s);
        System.out.println(new String(bytes));
        //hello

    }
}
