package com.cmos.itframe.shiro_demo.itframe.iservice.impl;

import com.alibaba.fastjson.JSONObject;
import com.cmos.itframe.shiro_demo.itframe.beans.Book;
import com.cmos.itframe.shiro_demo.itframe.dao.BookDao;
import com.cmos.itframe.shiro_demo.itframe.iservice.BookSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
