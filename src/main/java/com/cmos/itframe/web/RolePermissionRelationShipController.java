package com.cmos.itframe.web;

import com.cmos.itframe.beans.dto.RolePermDto;
import com.cmos.itframe.iservice.RolePermissionSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class RolePermissionRelationShipController {

    @Autowired
    private RolePermissionSV rolePermissionSV;

    //给角色赋予权限
    public Map addRolePerm(RolePermDto rolePermDto){
        return rolePermissionSV.addRolePermRelationShip(rolePermDto);
    }

    //
}
