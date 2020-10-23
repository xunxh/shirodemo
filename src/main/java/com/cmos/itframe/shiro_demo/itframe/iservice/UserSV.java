package com.cmos.itframe.shiro_demo.itframe.iservice;

import com.cmos.itframe.shiro_demo.itframe.beans.User;

public interface UserSV {
    User getByUserName(String username);
    void addUser(User user);
}
