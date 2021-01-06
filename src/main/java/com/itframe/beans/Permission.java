package com.itframe.beans;

public class Permission {
    private Integer pid;
    private String permname;
    private String url;
    private Integer types; // 1：菜单  2：按钮
    private Integer parentId=1;
    private String remark;

    public Permission(Integer pid, String permname, String url, Integer types, Integer parentId, String remark) {
        this.pid = pid;
        this.permname = permname;
        this.url = url;
        this.types = types;
        this.parentId = parentId;
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPermname() {
        return permname;
    }

    public void setPermname(String permname) {
        this.permname = permname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Permission() {
    }

    public Permission(Integer pid, String permname, String url, Integer types, Integer parentId) {
        this.pid = pid;
        this.permname = permname;
        this.url = url;
        this.types = types;
        this.parentId = parentId;
    }

    public Permission(String permname, String url, Integer types, Integer parentId, String remark) {
        this.permname = permname;
        this.url = url;
        this.types = types;
        this.parentId = parentId;
        this.remark = remark;
    }
}
