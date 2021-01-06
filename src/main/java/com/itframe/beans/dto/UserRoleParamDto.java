package com.itframe.beans.dto;

import com.itframe.beans.Role;

import java.io.Serializable;
import java.util.List;

public class UserRoleParamDto implements Serializable {

    private Integer userId;
    private String username;
    private List<Role> userRoleRelationShips;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Role> getUserRoleRelationShips() {
        return userRoleRelationShips;
    }

    public void setUserRoleRelationShips(List<Role> userRoleRelationShips) {
        this.userRoleRelationShips = userRoleRelationShips;
    }
}
