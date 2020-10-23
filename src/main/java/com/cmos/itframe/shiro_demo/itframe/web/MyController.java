package com.cmos.itframe.shiro_demo.itframe.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/login1")
    //@GetMapping("/login1")
    public String login1(){
        return "login";
    }

    @RequestMapping("/getBook")
    public String getBook(){
        return "book/showAllBooks";
    }
}
