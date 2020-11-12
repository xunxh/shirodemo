package com.cmos.itframe.iservice;

import com.alibaba.fastjson.JSON;
import com.cmos.itframe.beans.User;

import java.util.Map;


public interface UserSV {
    User getByUserName(String username);

    User getUserById(Integer uid);

    Map addUser(User user);

    Map updateUser(User user);

    Map deleteUser(Integer uid);

    Map getUsers(Integer page, Integer limit, String keyWord);
}
