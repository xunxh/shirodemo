package com.cmos.itframe.shiro_demo.itframe.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cmos.itframe.shiro_demo.itframe.beans.Book;
import com.cmos.itframe.shiro_demo.itframe.iservice.BookSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookSV bookSV;

    @RequestMapping(value = "/getAllBooks",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getAllBooks(Integer page, Integer limit){

        return bookSV.selectAll(page, limit);
    }

}
