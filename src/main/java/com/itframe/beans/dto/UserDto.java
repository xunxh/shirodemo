package com.itframe.beans.dto;

import com.itframe.beans.Role;
import com.itframe.beans.User;

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
