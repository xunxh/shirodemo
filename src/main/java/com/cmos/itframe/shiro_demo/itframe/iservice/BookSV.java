package com.cmos.itframe.shiro_demo.itframe.iservice;

import com.cmos.itframe.shiro_demo.itframe.beans.Book;



import java.util.Map;

public interface BookSV {
    String selectAll(Integer offset, Integer limit);
    int getNums();
    void saveBook(Book book);
    void updateBook(Book book);
    void delByPrimaryKey(Integer bid);
}
