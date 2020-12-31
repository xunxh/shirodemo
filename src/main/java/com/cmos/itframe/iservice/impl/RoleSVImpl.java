package com.cmos.itframe.iservice.impl;

import com.cmos.itframe.beans.Permission;
import com.cmos.itframe.beans.Role;
import com.cmos.itframe.beans.RolePermissionRelationShip;
import com.cmos.itframe.beans.User;
import com.cmos.itframe.beans.dto.RoleDto;
import com.cmos.itframe.dao.PermissionDao;
import com.cmos.itframe.dao.RoleDao;
import com.cmos.itframe.dao.RolePermissionRelationShipDao;
import com.cmos.itframe.iservice.RoleSV;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleSVImpl implements RoleSV {
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private RolePermissionRelationShipDao rolePermissionRelationShipDao;

    @Override
    public Map getRoles(String keyWord,Integer page,Integer limit) {
        if(page==null){
            page=1;
        }
        if(limit==null){
            limit=9999;
        }
        Map maps=new HashMap();
        List<Role> roleList=roleDao.getRoles(keyWord);
        List<Permission> permissions=permissionDao.getAllPermissions("");
        Map<Integer,Permission> map1=new HashMap<>();
        for(Permission p:permissions){
            map1.put(p.getPid(),p);
        }
        List<RoleDto> roleDtos=new ArrayList<>();
        for(Role r:roleList){
            RoleDto roleDto=new RoleDto();
            roleDto.setRid(r.getRid());
            roleDto.setRemark(r.getRemark());
            roleDto.setRoleLevel(r.getRoleLevel());
            roleDto.setRolename(r.getRolename());
            roleDto.setStatus(r.getStatus());
            roleDto.setPermissions(new ArrayList<>());
            RolePermissionRelationShip relationShip=new RolePermissionRelationShip();
            relationShip.setRid(r.getRid());
            List<RolePermissionRelationShip> permissionRelationShips=rolePermissionRelationShipDao.getRolePermissionRelationShip(relationShip);
            for(RolePermissionRelationShip rp:permissionRelationShips){
                if(map1.keySet().contains(rp.getPid())){
                    roleDto.getPermissions().add(map1.get(rp.getPid()));
                }
            }
            roleDtos.add(roleDto);
        }
        //角色信息按照等级排序
        Collections.sort(roleDtos, new Comparator<RoleDto>() {
            @Override
            public int compare(RoleDto o1, RoleDto o2) {
                if (o1.getRoleLevel() > o2.getRoleLevel()) {
                    return 1;
                }
                if (o1.getRoleLevel() == o2.getRoleLevel()) {
                    return 0;
                }
                return -1;
            }
        });
        PageHelper.startPage(page,limit);
        PageInfo<RoleDto> pageInfo=new PageInfo<>(roleDtos);
        maps.put("code",0);
        maps.put("msg","");
        maps.put("count",roleList.size());
        maps.put("data",pageInfo.getList());
        return maps;
    }

    @Override
    public Map updateRole(Role role) {
        int i = roleDao.updateRole(role);
        Map map = new HashMap();
        if(i>0){
            map.put("isUpdate",true);
        }else{
            map.put("isUpdate",false);
        }
        return map;
    }

    @Override
    public Map deleteRoleById(Integer rid) {
        int i = roleDao.deleteRoleById(rid);
        Map map = new HashMap();
        if(i>0){
            map.put("isDelete","删除成功");
        }else{
            map.put("isDelete","删除失败");
        }
        return map;
    }

    @Override
    public Map addRole(Role role) {
        int i = roleDao.addRole(role);
        Map map = new HashMap();
        if(i>0){
            map.put("isAdd",true);
        }else{
            map.put("isAdd",false);
        }
        return map;
    }

    @Override
    public Role getRoleById(Integer rid) {
        return roleDao.getRoleById(rid);
    }

    @Override
    public List<Role> getRoleIdAndRoleName() {
        return roleDao.getRoleIdAndRoleName();
    }
}
