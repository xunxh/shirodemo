package com.itframe.beans.dto;

import com.itframe.beans.Permission;
import com.itframe.beans.Role;

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
