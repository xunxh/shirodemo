package com.cmos.itframe.shiro_demo.itframe.beans;

import org.apache.shiro.util.ByteSource;

import java.util.List;

public class User {
    private Integer uid;
    private String username;
    private String password;
    private String salt; //盐值
    private Integer enable=1;//是否可用  0 不可用  1可用
    private String email;
    private List<Permission> permList;
    private List<Role> roleList;

    public User(String username, String password, Integer enable, String email) {
        this.username = username;
        this.password = password;
        this.enable = enable;
        this.email = email;
    }

    public User(Integer uid, String username, String password, String salt) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.salt = salt;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }
}
