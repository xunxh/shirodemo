package com.cmos.itframe.shiro_demo.itframe.iservice.impl;

import com.cmos.itframe.shiro_demo.itframe.beans.User;
import com.cmos.itframe.shiro_demo.itframe.dao.UserDao;
import com.cmos.itframe.shiro_demo.itframe.iservice.UserSV;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSVImpl implements UserSV {
    @Autowired
    private UserDao userDao;
    @Override
    public User getByUserName(String username) {
        return userDao.getByUserName(username);
    }

    @Override
    public void addUser(User user) {
        String password=user.getPassword();
        //生成盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername());
       String salt=credentialsSalt.toString();
        //加密
        SimpleHash simpleHash=new SimpleHash("MD5",password,credentialsSalt,1);
        //得到加密后的密码
        password=simpleHash.toString();
        user.setPassword(password);
        user.setSalt(salt);
        userDao.addUser(user);
    }
}
