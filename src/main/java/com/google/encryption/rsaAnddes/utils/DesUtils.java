package com.google.encryption.rsaAnddes.utils;


import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.springframework.util.Base64Utils;

public class DesUtils {

    /**
     * DES加密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptByKey(byte[] data, String key) throws Exception {
        // 可信任的随机数
        SecureRandom secureRandom = new SecureRandom();
        DESKeySpec keySpec = new DESKeySpec(key.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(keySpec);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, secureRandom);
        return cipher.doFinal(data);
    }

    public static byte[] decryptByKey(byte[] data, String key) throws Exception {
        // 可信任的随机数
        SecureRandom secureRandom = new SecureRandom();
        DESKeySpec keySpec = new DESKeySpec(key.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(keySpec);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, secureRandom);
        return cipher.doFinal(data);
    }

    public static void main(String[] args) throws Exception {
        StringBuffer sourceStr = new StringBuffer("月光宝盒");
        for (int i = 0; i < 1000; i++) {
            sourceStr.append(i);
        }
        System.out.println(sourceStr);
//        for (int i = 0; i <1000 ; i++) {
//            sourceStr+=sourceStr+i;
//        }这种代码直接报错  Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        String key = "12345678";
        System.out.println("待加密：" + sourceStr);
        byte[] encryptByte = DesUtils.encryptByKey(sourceStr.toString().getBytes(), key);
        String encryptStr = Base64Utils.encodeToString(encryptByte);
        System.out.println("加密后：" + encryptStr);
        byte[] decryptByte = DesUtils.decryptByKey(Base64Utils.decodeFromString(encryptStr), key);
        String decryptStr = new String(decryptByte);
        System.out.println("解密后：" + decryptStr);
    }

}
