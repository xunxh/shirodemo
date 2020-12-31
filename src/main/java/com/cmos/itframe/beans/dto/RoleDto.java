package com.cmos.itframe.beans.dto;

import com.cmos.itframe.beans.Permission;
import com.cmos.itframe.beans.Role;

import java.util.List;

public class RoleDto extends Role {

    private List<Permission> permissions;

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
