package com.cmos.itframe.shiro_demo.itframe.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/login")
    public String login(String username,String password){
        //获取subject对象
        Subject subject=SecurityUtils.getSubject();
        //如果已经登陆过，就退出
        if(subject.isAuthenticated()){
            subject.logout();
        }
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            System.out.println(username+"验证身份信息失败");
            e.printStackTrace();
            return "failed";
        }
        return "redirect:/Book/getAllBooks";
    }
}
