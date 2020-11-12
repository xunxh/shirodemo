package com.cmos.itframe.beans.dto;

public class RolePermDto {
    private Integer rpid;
    private Integer rid;
    private Integer[] pids;

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

    public Integer[] getPids() {
        return pids;
    }

    public void setPids(Integer[] pids) {
        this.pids = pids;
    }

    public RolePermDto() {
    }

    public RolePermDto(Integer rid, Integer[] pids) {
        this.rid = rid;
        this.pids = pids;
    }
}
