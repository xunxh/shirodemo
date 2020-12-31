package com.cmos.itframe.web;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

//    @RequestMapping("/login1")
    @GetMapping("/login")
    public String login1(){
        return "common/login";
    }

    @RequestMapping("/getBook")
    public String getBook(){
        return "book/showAllBooks";
    }

    @RequiresRoles("管理员,用户")
    @RequestMapping("/getuser")
    public String getuser(){
        return "user/showAllUsers";
    }

    @RequiresRoles("管理员")
    @RequestMapping("/getrole")
    public String getrole(){
        return "role/showAllRoles";
    }

    @RequiresRoles("管理员")
    @RequestMapping("/getperm")
    public String getperm(){
        return "permission/showAllPermission";
    }

    @RequiresAuthentication
    @RequestMapping("/getMainPermissions")
    public String getMainPermissions(){
        return "common/main";
    }
}
