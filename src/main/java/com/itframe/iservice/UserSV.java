package com.itframe.iservice;

import com.itframe.beans.User;

import java.util.Map;


public interface UserSV {
    User getByUserName(String username);

    String getPasswordByUsername(String username);

    User getUserById(Integer uid);

    Map addUser(User user);

    Map updateUser(User user);

    Map deleteUser(Integer uid);

    Map getUsers(Integer page, Integer limit, String keyWord);
}
