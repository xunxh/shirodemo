package com.itframe.beans;

public class Book {
    private Integer bid;
    private String bname;
    private String auth;
    private Double price;
    private Integer counts;
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public Book(Integer bid, String bname, String auth, Double price, Integer counts) {
        this.bid = bid;
        this.bname = bname;
        this.auth = auth;
        this.price = price;
        this.counts = counts;
    }

    public Book(String bname, String auth, Double price, Integer counts) {
        this.bname = bname;
        this.auth = auth;
        this.price = price;
        this.counts = counts;
    }

    public Book() {
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }
}
