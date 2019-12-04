package com.google.algorithm.encryption;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

import org.springframework.util.Base64Utils;

/**
 * @author wk
 */
public class Des {

    private static final String algorithm = "DES";
    private static final String key = "11111111";

    /**
     * 加密
     *
     * @return
     * @throws Exception
     */
    public static String encrypt(String data) {
        try {
            byte[] bt = encrypt(data.getBytes(), key.getBytes());
            return Base64Utils.encodeToString(bt);
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 解密
     *
     * @return
     * @throws Exception
     */
    public static String decrypt(String data) {
        if (data == null) {
            return null;
        }
        try {
            byte[] bt = decrypt(Base64Utils.decodeFromString(data), key.getBytes());
            return new String(bt);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据键值进行加密
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        return initCipher(data, key, Cipher.ENCRYPT_MODE);
    }

    /**
     * 根据键值进行解密
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        return initCipher(data, key, Cipher.DECRYPT_MODE);
    }

    public static byte[] initCipher(byte[] data, byte[] key, int decryptMode) throws Exception {
        /** 生成一个可信任的随机数源 **/
        SecureRandom sr = new SecureRandom();
        /** 从原始密钥数据创建DESKeySpec对象 **/
        DESKeySpec dks = new DESKeySpec(key);
        /** 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象 **/
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algorithm);
        /** 将DESKeySpec对象转换成SecretKey对象 **/
        SecretKey securekey = keyFactory.generateSecret(dks);
        /** Cipher对象实际完成加密或解密操作 **/
        Cipher cipher = Cipher.getInstance(algorithm);
        /** 用密钥初始化Cipher对象 **/
        cipher.init(decryptMode, securekey, sr);
        return cipher.doFinal(data);
    }

    public static void main(String[] args) {
        // 待加密内容
        String data = "hello";
        // 密码，长度要是8的倍数
        //加密
        String str = Des.encrypt(data);
        System.out.println(str);
        //解密
        System.out.println(Des.decrypt(str));
    }
}
