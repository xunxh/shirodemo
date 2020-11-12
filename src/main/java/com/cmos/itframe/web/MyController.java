package com.cmos.itframe.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/login1")
    //@GetMapping("/login1")
    public String login1(){
        return "common/login";
    }

    @RequestMapping("/getBook")
    public String getBook(){
        return "book/showAllBooks";
    }

    @RequestMapping("/getuser")
    public String getuser(){
        return "user/showAllusers";
    }

    @RequestMapping("/getrole")
    public String getrole(){
        return "role/showAllRoles";
    }

    @RequestMapping("/getperm")
    public String getperm(){
        return "permission/showAllPermissions";
    }

    @RequestMapping("/getMainPermissions")
    public String getMainPermissions(){
        return "common/main";
    }
}
