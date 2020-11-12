package com.cmos.itframe.beans;


import java.util.Date;

public class User {
    private Integer uid;
    private String username;
    private String realName;
    private String password;
    private Integer status=1;//是否可用  0 不可用  1可用
    private String email;
    private String mobile;
    private Date createTime;
    private String remark;//备注

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    private Date updateTime;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public User(String username, String realName, String password, Integer status, String email, String mobile, String remark) {
        this.username = username;
        this.realName = realName;
        this.password = password;
        this.status = status;
        this.email = email;
        this.mobile = mobile;
        this.remark = remark;
    }

    public User(Integer uid, String username, String realName, String password, Integer status, String email, String mobile, String remark) {
        this.uid = uid;
        this.username = username;
        this.realName = realName;
        this.password = password;
        this.status = status;
        this.email = email;
        this.mobile = mobile;
        this.remark = remark;
    }

    public User(Integer uid, String username, String realName, String password, Integer status, String email, String mobile, Date createTime, String remark, Date updateTime) {
        this.uid = uid;
        this.username = username;
        this.realName = realName;
        this.password = password;
        this.status = status;
        this.email = email;
        this.mobile = mobile;
        this.createTime = createTime;
        this.remark = remark;
        this.updateTime = updateTime;
    }


    public User(Integer uid, String username, String password) {
        this.uid = uid;
        this.username = username;
        this.password = password;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", createTime=" + createTime +
                ", remark='" + remark + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
