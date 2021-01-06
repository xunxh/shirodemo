package com.itframe.beans.dto;

import java.io.Serializable;
import java.util.Arrays;

public class UserRoleDto implements Serializable {
    private Integer uid;
    private String username;
    private Integer[] ids;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "UserRoleDto{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", ids=" + Arrays.toString(ids) +
                '}';
    }
}
