package com.cmos.itframe.web;

import com.cmos.itframe.beans.dto.RPDto;
import com.cmos.itframe.beans.dto.RolePermDto;
import com.cmos.itframe.beans.dto.UserRoleDto;
import com.cmos.itframe.beans.dto.UserRoleParamDto;
import com.cmos.itframe.iservice.UserRoleSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/userRole")
public class UserRoleController {
    @Autowired
    private UserRoleSV userRoleSV;
    //修改角色的权限
    @RequestMapping("/updateUserRole")
    public @ResponseBody
    Map updateRolePerm(@RequestBody UserRoleDto permDto) throws Exception {
//        System.out.println(data);
//        RPDto permDto=new RPDto();

        System.out.println(permDto);
        return userRoleSV.saveUserRoles(permDto);
    }

    //获取某个角色的权限
    @RequestMapping("/getUserRoles")
    public @ResponseBody
    UserRoleParamDto getRolePerms(@RequestParam Integer uid){
        return userRoleSV.getUserRoles(uid);
    }
}
