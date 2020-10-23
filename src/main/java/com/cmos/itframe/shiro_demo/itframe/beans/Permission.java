package com.cmos.itframe.shiro_demo.itframe.beans;

public class Permission {
    private Integer pid;
    private String permname;
    private String url;
    private Integer type;
    private Integer parentId;
    private Integer sort;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Permission() {
    }

    public Permission(Integer pid, String permname, String url, Integer type, Integer parentId, Integer sort) {
        this.pid = pid;
        this.permname = permname;
        this.url = url;
        this.type = type;
        this.parentId = parentId;
        this.sort = sort;
    }
}
