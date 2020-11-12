package com.cmos.itframe.beans;

public class RolePermissionRelationShip {
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

    public RolePermissionRelationShip() {
    }

    public RolePermissionRelationShip(Integer rid, Integer pid) {
        this.rid = rid;
        this.pid = pid;
    }
}
