package com.itframe.web;

import com.itframe.beans.User;
import com.itframe.iservice.UserRoleSV;
import com.itframe.iservice.UserSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserSV userSV;

    @Autowired
    private UserRoleSV userRoleSV;

    //查询全部用户信息
//    @RequiresPermissions("查看用户")
    @RequestMapping("/getUsers")
    public @ResponseBody Map getUsers(@RequestParam(value = "page",required = false) Integer page,
                 @RequestParam(value = "limit",required = false) Integer limit,
                 @RequestParam(value = "keyWord",required = false) String keyWord){

        return userSV.getUsers(page, limit, keyWord);
    }

    //根据id查询用户信息
    @RequestMapping("/getUserById")
    public @ResponseBody User getUserById(@RequestParam(value = "uid",required = true) Integer uid){
        return userSV.getUserById(uid);
    }

    //删除用户信息
    @RequestMapping("deleteUserById")
    public @ResponseBody Map deleteUser(@RequestParam(value = "uid",required = false)Integer uid){
        return userSV.deleteUser(uid);
    }

    //添加用户信息
    @RequestMapping("/addUser")
    public @ResponseBody Map addUser(User user){
        return userSV.addUser(user);
    }

    //修改用户信息
    @RequestMapping("/updateUser")
    public @ResponseBody Map updateUser(User user){
        return userSV.updateUser(user);
    }

}
