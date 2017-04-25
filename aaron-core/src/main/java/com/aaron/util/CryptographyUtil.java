package com.aaron.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

public class CryptographyUtil {
  
    /** 
     * base64加密 
     * @param str 
     * @return 
     */  
    public static String encBase64(String str){  
        return Base64.encodeToString(str.getBytes());
    }  
      
    /** 
     * base64解密 
     * @param str 
     * @return 
     */  
    public static String decBase64(String str){  
        return Base64.decodeToString(str);  
    }  
      
    /** 
     * Md5加密      Shiro中自带MD5没有解密 
     * @param str   要加密的值 
     * @param salt<span style="white-space:pre">  </span>可以看做是拌料 
     * @return 
     */  
    public static String md5(String str,String salt){  
        return new Md5Hash(str,salt).toString();
    }

    public static String md5(String str){
        return new Md5Hash(str).toString();
    }
      
    public static void main(String[] args) {  
        String password="admin";
        System.out.println("Base64加密："+CryptographyUtil.encBase64(password));  
        System.out.println("Base64解密："+CryptographyUtil.decBase64(CryptographyUtil.encBase64(password)));  
        //MD5加密应用到实际项目中开发比如：注册提交数据是对密码进行MD5加密就会得到一串这样的70f57208b804bd90d51fdac84afe6472字符串储存到数据库  
        //这就是MD5加密过后的密码，做用户验证是把数据库获取到的密码在对比  
        System.out.println("Md5加密："+CryptographyUtil.md5(password, "java1234"));
        System.out.println("Md5加密："+CryptographyUtil.md5(password));

    }  
}