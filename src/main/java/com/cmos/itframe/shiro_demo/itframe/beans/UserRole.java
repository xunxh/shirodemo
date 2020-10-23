package com.cmos.itframe.shiro_demo.itframe.beans;

public class UserRole {
    private Integer urid;
    private Integer uid;
    private Integer rid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public UserRole() {
    }

    public UserRole(Integer uid, Integer rid) {
        this.uid = uid;
        this.rid = rid;
    }
}
