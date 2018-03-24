package com.ability.emp.util;

import java.security.AlgorithmParameters;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;


/**
 * 解密工具类
 * @author Devin
 * @since 2018-3-23
 *
 */
public class AESEncryptionUtil {
	
	
	 private static final String KEY_ALGORITHM = "AES/CBC/PKCS7Padding";
	 
	 static {
	        Security.addProvider(new BouncyCastleProvider());
	 }
  
      /**
       * 解密
       * @param data
       * @param key
       * @param iv
       * @return
       * @throws Exception
       */
      public static String decrypt(String data, String key,String iv) throws Exception {  
          byte[] dataByte = Base64.decodeBase64(data);
          byte[] keyByte = Base64.decodeBase64(key);
          byte[] ivByte = Base64.decodeBase64(iv);
          
          Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
          SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
          AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
          parameters.init(new IvParameterSpec(ivByte));
          cipher.init(Cipher.DECRYPT_MODE, spec,parameters);  
    
          byte[] resultByte = cipher.doFinal(dataByte);
          if (null != resultByte && resultByte.length > 0) {
              String result = new String(resultByte, "UTF-8");
              return result;
          }
          return "";  
      }  
      
}
