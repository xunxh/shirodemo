package com.itframe.dao;

import com.itframe.beans.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {
    List<Book>  getAll(@Param("offset") Integer offset, @Param("limit") Integer limit);
    int getNum();
    void saveBook(Book book);
    void updateBook(Book book);
    void delByPrimaryKey(@Param("id") Integer bid);
}
