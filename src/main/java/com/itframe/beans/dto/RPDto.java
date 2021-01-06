package com.itframe.beans.dto;

import java.io.Serializable;
import java.util.Arrays;

public class RPDto implements Serializable {
    private Integer rid;
    private String rolename;
    private Integer[] ids;

//    public String getRid() {
//        return rid;
//    }
//
//    public void setRid(String rid) {
//        this.rid = rid;
//    }

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

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "RPDto{" +
                "rid=" + rid +
                ", rolename='" + rolename + '\'' +
                ", ids=" + Arrays.toString(ids) +
                '}';
    }
}
