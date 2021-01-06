package com.itframe.web;

import com.itframe.iservice.BookSV;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookSV bookSV;

    @RequiresAuthentication
    @RequestMapping(value = "/getAllBooks",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getAllBooks(Integer page, Integer limit){

        return bookSV.selectAll(page, limit);
    }

}
