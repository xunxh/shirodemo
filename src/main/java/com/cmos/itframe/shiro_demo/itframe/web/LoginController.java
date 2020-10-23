package com.cmos.itframe.shiro_demo.itframe.web;

import com.cmos.itframe.shiro_demo.itframe.beans.User;
import com.cmos.itframe.shiro_demo.itframe.iservice.UserSV;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserSV userSV;

    @RequestMapping("/userlogin")
    public String login(String username,String password){
        //获取subject对象
        Subject subject= SecurityUtils.getSubject();
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
        return "main";
    }
}
