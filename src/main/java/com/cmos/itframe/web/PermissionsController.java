package com.cmos.itframe.web;

import com.cmos.itframe.beans.Permission;
import com.cmos.itframe.iservice.PermissionSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
@RequestMapping("/permissions")
public class PermissionsController {

    @Autowired
    private PermissionSV permissionSV;

    //查询所有权限信息
    @RequestMapping("/getAllPermissions")
    public @ResponseBody Map getAllPermissions(@RequestParam(value = "page",required = false) Integer page,
                                               @RequestParam(value = "limit",required = false) Integer limit,
                                               @RequestParam(value = "keyWord",required = false) String keyWord){
        return permissionSV.getAllPermissions(keyWord, page, limit);
    }

    //添加权限信息
    @RequestMapping("/addPermission")
    public @ResponseBody Map addPermission(Permission permission){
        return permissionSV.addPermission(permission);
    }

    //删除权限信息
    @RequestMapping("/deletePermission")
    public @ResponseBody Map deletePermission(Integer pid){
        return permissionSV.deletePermissionById(pid);
    }

    //修改权限信息
    @RequestMapping("/updatePermission")
    public @ResponseBody Map updatePermission(Permission permission){
        return permissionSV.updatePermission(permission);
    }

    //获取初始化权限
    @RequestMapping("/getMainPerm")
    public @ResponseBody Map getMainPerm(){
        return permissionSV.getUserPerms();
    }

    //根据id获取权限信息
    @RequestMapping("/getPermissionById")
    public @ResponseBody Permission getPermissionById(@RequestParam(value = "pid",required = true)Integer pid){
        return permissionSV.getPermissionById(pid);
    }
}
