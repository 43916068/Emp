package com.ability.emp.util;

import java.security.MessageDigest;

/**
 * 基础加密组件
 * @author Devin
 * @since 2018-4-6
 * @version 1.0
 * 
 */
public abstract class Encryption {
    
    public static final String KEY_MD5 = "MD5";


    /*** 
     * MD5加密生成32位md5码
     * @param password 明文密码
     * @return 返回加密后的密码
     */  
    public static String Md5Encrypt(String password){  
        MessageDigest md5=null;  
        try
        {  
            md5=MessageDigest.getInstance(KEY_MD5);//返回实现指定摘要算法的 MessageDigest对象  
        }catch(Exception e){  
            System.out.println(e.toString());  
            e.printStackTrace();  
            return "";  
        }  
        char[] charArray=password.toCharArray();//明文密码转换为字符数组  
        byte[] byteArray=new byte[charArray.length];//创建字节数组，长度为明文密码字符数组长度  
  
        for(int i=0; i<charArray.length; i++)  
            byteArray[i]=(byte)charArray[i];//将每个字符转换为字节  
            byte[] md5Bytes=md5.digest(byteArray);//调用digest方法完成单向哈希函数计算  
            StringBuffer hexValue=new StringBuffer();  
            for(int i=0; i<md5Bytes.length; i++){  
            int val=((int)md5Bytes[i]) & 0xff;//将字节中的负值转换为正值  
            if(val<16) 
                hexValue.append("0");  
                hexValue.append(Integer.toHexString(val));//返回参数的十六进制（基数 16）无符号整数值的字符串表示形式。
            } 
        return hexValue.toString();  
    }
    
}

