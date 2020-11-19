package com.cmos.itframe.beans.dto;

import com.cmos.itframe.beans.Permission;

import java.util.Arrays;
import java.util.List;

public class RolePermDto {
    private Integer rpid;
    private Integer rid;
    private String rolename;
    private List<Permission> permissionList;

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

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
