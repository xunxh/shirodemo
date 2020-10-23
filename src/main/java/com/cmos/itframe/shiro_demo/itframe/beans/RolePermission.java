package com.cmos.itframe.shiro_demo.itframe.beans;

public class RolePermission {
    private Integer rpid;
    private Integer rid;
    private Integer pid;

    public Integer getRpid() {
        return rpid;
    }

    public void setRpid(Integer rpid) {
        this.rpid = rpid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public RolePermission(Integer rid, Integer pid) {
        this.rid = rid;
        this.pid = pid;
    }
}
