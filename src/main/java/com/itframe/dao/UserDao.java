package com.itframe.dao;

import com.itframe.beans.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    User getByUserName(@Param("username") String username);
    int addUser(User user);
    int deleteById(@Param("id")Integer id);
    User getById(@Param("id")Integer id);
    int updateUser(User user);
    List<User> getByKeyWord(@Param("keyWord") String keyWord);
    String getPasswordByUsername(@Param("username") String username);
}
