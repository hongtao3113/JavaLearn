package com.google.encryption.rsaAnddes;


import org.apache.commons.lang3.RandomStringUtils;

import com.google.encryption.rsaAnddes.utils.DesUtils;
import com.google.encryption.rsaAnddes.utils.RsaUtils;
import org.springframework.util.Base64Utils;


public class EncryptManager {

    private static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCS3tyLB+gzLIGdO21Dem4JLp5TZGYWJUQl9vvUcMTbt0u4fjqlQp8musB4uc7EJ/DrBrR+HB2aoq7LknlNtCnfOH1WuMIXfQdfV1oiR0yi+ZCSjZQB+jRCO19NEWqMhUcBeZcx8em/UKXP6CmSINln6ttZGnbl12deOEQ+keoPIwIDAQAB";
    private static final String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJLe3IsH6DMsgZ07bUN6bgkunlNkZhYlRCX2+9RwxNu3S7h+OqVCnya6wHi5zsQn8OsGtH4cHZqirsuSeU20Kd84fVa4whd9B19XWiJHTKL5kJKNlAH6NEI7X00RaoyFRwF5lzHx6b9Qpc/oKZIg2Wfq21kaduXXZ144RD6R6g8jAgMBAAECgYAO8OMItb42boGlCCWeZrcI8hgjLaSA/juHjS+jNfGg1G28kALRSwy7uOXZojVZmSKWFjGIXr3YPFKB3R2//OMBbO5ep5Lu62iBLmXgdYwEXV1o0c1ZYkgDKF9tYN+Yv5nHB5bSZ4QnxpZ3LudvNNuUKqLFlDlHwWO6pKmr5cc7yQJBAPEbrse8d0u8cn5T0Xj+3WQ2kGm92ExyOn5sHLlnKPL4IKz3xbbLZWS3O8s1UhB4csPrcc2yEbc6hs5sHO1nFKUCQQCb8SCNUWeUpo8LhBMpIqd28vDaTDrRh5whwsdGbYkn2TPDc4i1lkHbGrTt5IqLh5XNKi79QHiiv5kAZBv7GCInAkA2LDcgD5tqO+QpuCF3oyQRMSVPbOVdf8jewOHPUntj5BZLZrxYruiQMY9QwCE5LCb1GECQq/LJDXBejvIM8T01AkASK/4kGaldXC9tIx3sfDpRlSvV9G4iPpBGKuF35onGF/x9OThkGLdh5fHRiwFOEyW0u8awAlRMetFEh2XvU7efAkA9CUF86C6OhlfAof15UienWPOtds2I4xr68Foh0xhZAf9sJoYIX1gKuCg87V1Sxsp2O/lfKWwaYpNlZncjzyYV";

    private String pingKey = null;
    private String workKey = null;
    private String mobKey = null;

    public String getPingKey() {
        return pingKey;
    }

    public void setPingKey(String pingKey) {
        this.pingKey = pingKey;
    }

    public String getWorkKey() {
        return workKey;
    }

    public void setWorkKey(String workKey) {
        this.workKey = workKey;
    }

    public String getMobKey() {
        return mobKey;
    }

    public void setMobKey(String mobKey) {
        this.mobKey = mobKey;
    }

    private void assambleMobKey() {
        String mobKeyStr = this.getPingKey() + this.getWorkKey();
        String mob = null;
        try {
            mob = Base64Utils.encodeToString(RsaUtils.encryptByPublicKey(mobKeyStr.getBytes(), publicKey));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setMobKey(mob);
        ;
    }

    public EncryptManager() {

    }

    public void init() {
        this.setPingKey(RandomStringUtils.random(24, "1234567890"));
        this.setWorkKey(RandomStringUtils.random(24, "1234567890"));
        this.assambleMobKey();
        System.out.println("pingKey:" + this.getPingKey());
        System.out.println("workKey:" + this.getWorkKey());
        System.out.println("mobKey:" + this.getMobKey());
    }

    /**
     * 加密数据
     *
     * @param data
     * @return
     */
    public String encryptStr(String data) {
        if (data == null || "".equals(data.trim())) {
            return null;
        }
        try {
            byte[] result = DesUtils.encryptByKey(data.getBytes(), this.getPingKey());
            return Base64Utils.encodeToString(result);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 解密数据
     *
     * @param data
     * @return
     */
    public String decryptStr(String data) {
        if (data == null || "".equals(data.trim())) {
            return null;
        }
        try {
            byte[] resultByte = DesUtils.decryptByKey(Base64Utils.decodeFromString(data), this.getPingKey());
            String result = new String(resultByte);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过mobKey获取pingKey和workKey
     *
     * @param mobKey
     */
    public void parseMobKey(String mobKey) {
        if (mobKey == null || "".equals(mobKey.trim())) {
            return;
        }
        try {
            byte[] mobKeyByte = Base64Utils.decodeFromString(mobKey);
            byte[] resultByte = RsaUtils.decryptByPrivateKey(mobKeyByte, privateKey);
            String result = new String(resultByte);
            String pingKey = result.substring(0, 24);
            String workKey = result.substring(24, 48);
            this.setPingKey(pingKey);
            this.setWorkKey(workKey);
            System.out.println("pingKey:" + pingKey);
            System.out.println("workKey:" + workKey);
            System.out.println("mobKey:" + mobKey);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public static void main(String[] args) {
        EncryptManager encryptManager = new EncryptManager();
        encryptManager.init();
        System.out.println(privateKey.length());
        System.out.println(publicKey.length());
    }

}
