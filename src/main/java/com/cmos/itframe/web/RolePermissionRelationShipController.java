package com.cmos.itframe.web;

import com.cmos.itframe.beans.dto.RolePermDto;
import com.cmos.itframe.iservice.RolePermissionSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/rolePerm")
public class RolePermissionRelationShipController {

    @Autowired
    private RolePermissionSV rolePermissionSV;

    //给角色赋予权限
    @RequestMapping("/addRolePerm")
    public @ResponseBody Map addRolePerm(RolePermDto rolePermDto){
        return rolePermissionSV.addRolePermRelationShip(rolePermDto);
    }

    //删除角色的某些权限
    @RequestMapping("/deleteRolePerm")
    public @ResponseBody Map deleteRolePerm(Integer[] ids){
        return rolePermissionSV.deleteRolePermByPids(ids);
    }

    //获取某个角色的权限
    @RequestMapping("/getRolePerms")
    public @ResponseBody RolePermDto getRolePerms(@RequestParam Integer rid){
        return rolePermissionSV.getRolePermsByRid(rid);
    }
}
