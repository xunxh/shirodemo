package com.cmos.itframe.web;

import com.cmos.itframe.beans.dto.RPDto;
import com.cmos.itframe.beans.dto.RolePermDto;
import com.cmos.itframe.iservice.RolePermissionSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    //修改角色的权限
    @RequestMapping("/updateRolePerm")
    public @ResponseBody Map updateRolePerm(@RequestBody RPDto permDto){
//        System.out.println(data);
//        RPDto permDto=new RPDto();

        System.out.println(permDto);
        return rolePermissionSV.updateRolePermByPids(permDto);
    }

    //获取某个角色的权限
    @RequestMapping("/getRolePerms")
    public @ResponseBody RolePermDto getRolePerms(@RequestParam Integer rid){
        return rolePermissionSV.getRolePermsByRid(rid);
    }
}
