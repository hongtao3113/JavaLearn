package com.google.encryption.rsaAnddes.utils;


import org.springframework.util.Base64Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class SignUtils {


    /**
     * 生成签名
     *
     * @param params
     * @param workKey
     * @return
     */
    public static String getSign(Map<String, Object> params, String workKey) {

        if (params == null) {
            return null;
        }
        params.remove("sign");
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        StringBuffer sb = new StringBuffer();
        for (String key : keys) {
            String value = (String) params.get(key);
            if (value != null && !"".equals(value.trim())) {
                sb.append(value);
            }
        }

        try {
            byte[] signByte = DesUtils.encryptByKey(sb.toString().getBytes(), workKey);
            return Base64Utils.encodeToString(signByte);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 验签
     *
     * @param params
     * @return
     */
    public static boolean verifySign(Map<String, Object> params, String workKey) {

        String sign = (String) params.get("sign");

        return sign.equals(SignUtils.getSign(params, workKey));
    }
}

