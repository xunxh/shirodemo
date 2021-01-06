package com.itframe.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 加密工具类
 */
public class PwdUtil {
    public static String getPwd(String password,String username){
        String str= new String();
        //生成盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);
        String salt=credentialsSalt.toString();
        //加密
        SimpleHash simpleHash=new SimpleHash("MD5",password,credentialsSalt,1);
        //得到加密后的密码
        password=simpleHash.toString();
        str=password;
        return str;
    }

}
