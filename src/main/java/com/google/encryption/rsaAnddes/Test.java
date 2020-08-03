package com.google.encryption.rsaAnddes;

import java.util.HashMap;
import java.util.Map;

import com.google.encryption.rsaAnddes.utils.SignUtils;

/**
 * 报文传输协议：
 * RSA对加密解密秘钥和加签解签秘钥进行加密
 * DES通过秘钥进行数据的加密解密和加签解签
 * RSA通过公钥加密、私钥解密
 * <p>
 * 加解密秘钥pingKey和加解签秘钥workKey为随机生成的24为字符串
 * mobKey为通过RSA将pingKey和workKey拼接然后加密生成的秘钥串
 * <p>
 * 步骤：
 * <p>
 * 1、通过方法RsaUtils.genKeyPair()生成公钥和私钥（也可通过网络工具生成），分配给下游商户
 * 下游：
 * 2、随机生成两个秘钥（加解密pingKey和加解签workKey）
 * 3、通过RsaUtils.encryptByPublicKey()和公钥加密得到mobKey
 * 4、通过DesUtils.encryptByKey()对数据项加密
 * 5、通过DesUtils.encryptByKey()对数据项加签，得到sign
 * 6、将sign、mobKey、加密的数据，组装成报文传输
 * 平台：
 * 7、获取报文中的mobKey、sign
 * 8、通过RsaUtils.decryptByPrivateKey()和私钥解密mobKey，得到两个秘钥（加解密pingKey和加解签workKey）
 * 9、通过DesUtils.decryptByKey()对数据项加签，对比sign值验签
 * 10、通过DesUtils.decryptByKey()对数据项解密，得到明文数据
 * <p>
 * 返回下游的报文加解密和加解签流程同上
 * <p>
 * （代码有些判断不严谨，请在实际的代码中进行完善。）
 */

public class Test {

    private void sendMessage(Map<String, Object> params) {

        EncryptManager encryptManager = new EncryptManager();
        encryptManager.init();

        params.put("name", encryptManager.encryptStr("周星星")); // 加密
        params.put("sex", "男");
        params.put("age", encryptManager.encryptStr("10"));

        params.put("mobKey", encryptManager.getMobKey());

        // 签名
        params.put("sign", SignUtils.getSign(params, encryptManager.getWorkKey()));

    }

    private void receviceMessage(Map<String, Object> params) {

        // 通过mobKey获取pingKey和workKey
        String mobKey = (String) params.get("mobKey");
        EncryptManager encryptManager = new EncryptManager();
        encryptManager.parseMobKey(mobKey);

        // 验签
        if (!SignUtils.verifySign(params, encryptManager.getWorkKey())) {
            System.out.println("验签失败");
            return;
        }

        params.put("name", encryptManager.decryptStr((String) params.get("name")));
        params.put("age", encryptManager.decryptStr((String) params.get("age")));
    }

    public static void main(String[] args) {
        Test test = new Test();
        Map<String, Object> params = new HashMap<String, Object>();
        test.sendMessage(params);
        test.receviceMessage(params);
    }

}

