package com.cmos.itframe.shiro_demo.itframe.dao;

import com.cmos.itframe.shiro_demo.itframe.beans.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User getByUserName(@Param("username") String username);
    void addUser(User user);
    void deleteById(@Param("id")Integer id);
    User getById(@Param("id")Integer id);
}
