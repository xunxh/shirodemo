package com.itframe.iservice;

import com.itframe.beans.Book;

public interface BookSV {
    String selectAll(Integer offset, Integer limit);
    int getNums();
    void saveBook(Book book);
    void updateBook(Book book);
    void delByPrimaryKey(Integer bid);
}
