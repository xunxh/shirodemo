package com.cmos.itframe.beans.dto;

import com.cmos.itframe.beans.Role;
import com.cmos.itframe.beans.User;

import java.util.List;

public class UserDto extends User {
    List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
