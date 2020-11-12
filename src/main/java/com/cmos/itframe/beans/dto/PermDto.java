package com.cmos.itframe.beans.dto;

import java.util.List;

public class PermDto {
    private Integer id;
    private String name;
    private String href;
    private List<PermDto> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<PermDto> getChildren() {
        return children;
    }

    public void setChildren(List<PermDto> children) {
        this.children = children;
    }
}
