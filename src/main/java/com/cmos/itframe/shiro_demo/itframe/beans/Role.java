package com.cmos.itframe.shiro_demo.itframe.beans;

public class Role {
    private Integer rid;
    private String rolename;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Role() {
    }

    public Role(Integer rid, String rolename) {
        this.rid = rid;
        this.rolename = rolename;
    }
}
