package com.itframe.iservice.impl;

import com.alibaba.fastjson.JSONObject;
import com.itframe.beans.Book;
import com.itframe.dao.BookDao;
import com.itframe.iservice.BookSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookSVImpl implements BookSV {
    @Autowired
    private BookDao bookDao;
    @Override
    public String selectAll(Integer page, Integer limit) {
        JSONObject object=new JSONObject();
        Integer start =(page-1)*limit;
        List<Book> books=bookDao.getAll(start,limit);
        int count=bookDao.getNum();
        object.put("code",0);
        object.put("msg","");
        object.put("count",count);
        object.put("data",books);
        return object.toJSONString();
    }

    @Override
    public int getNums() {
        return bookDao.getNum();
    }

    @Override
    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public void delByPrimaryKey(Integer bid) {
        bookDao.delByPrimaryKey(bid);
    }
}
