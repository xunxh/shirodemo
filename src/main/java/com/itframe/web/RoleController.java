package com.itframe.web;


import com.itframe.beans.Role;
import com.itframe.iservice.RoleSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleSV roleSV;

    //查询所有角色信息
    @RequestMapping("/getAllRoles")
    public @ResponseBody Map getAllRoles(@RequestParam(value = "page",required = false) Integer page,
                                         @RequestParam(value = "limit",required = false) Integer limit,
                                         @RequestParam(value = "keyWord",required = false) String keyWord){
        return roleSV.getRoles(keyWord, page, limit);
    }

    //添加角色信息
    @RequestMapping("/addRole")
    public @ResponseBody Map addRole(Role role){
        return roleSV.addRole(role);
    }

    //修改角色信息
    @RequestMapping("/updateRole")
    public @ResponseBody Map updateRole(Role role){
        return roleSV.updateRole(role);
    }

    //删除角色信息
    @RequestMapping("/deleteRole")
    public @ResponseBody Map deleteRoleById(@RequestParam(value = "rid",required = false) Integer rid){
        return roleSV.deleteRoleById(rid);
    }

    //获取单个角色信息
    @RequestMapping("/getRoleById")
    public @ResponseBody Role getRoleById(@RequestParam(value = "rid",required = false) Integer rid){
        return roleSV.getRoleById(rid);
    }

    //获取角色id和角色名字
    @RequestMapping("/getRoleIdAndRoleName")
    public @ResponseBody List<Role> getRoleIdAndRoleName(){
        return roleSV.getRoleIdAndRoleName();
    }

}
