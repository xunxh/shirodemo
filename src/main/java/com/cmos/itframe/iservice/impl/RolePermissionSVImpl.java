package com.cmos.itframe.iservice.impl;

import com.cmos.itframe.beans.Permission;
import com.cmos.itframe.beans.Role;
import com.cmos.itframe.beans.RolePermissionRelationShip;
import com.cmos.itframe.beans.dto.PermDto;
import com.cmos.itframe.beans.dto.RolePermDto;
import com.cmos.itframe.dao.PermissionDao;
import com.cmos.itframe.dao.RoleDao;
import com.cmos.itframe.dao.RolePermissionRelationShipDao;
import com.cmos.itframe.iservice.RolePermissionSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class RolePermissionSVImpl implements RolePermissionSV {
    @Autowired
    private RolePermissionRelationShipDao rolePermissionRelationShipDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public Map addRolePermRelationShip(RolePermDto rolePermDto) {
        Map map=new HashMap();
        List<Permission> permissions=rolePermDto.getPermissionList();
        Integer[] pids=new Integer[]{};
        for(int i=0;i<permissions.size();i++){
            pids[i]=permissions.get(i).getPid();
        }
        int count=1;
        for(int i=0;i<pids.length;i++){
            RolePermissionRelationShip rolePermissionRelationShip=new RolePermissionRelationShip(rolePermDto.getRid(),pids[i]);
            int j=rolePermissionRelationShipDao.addRolePermRelationShip(rolePermissionRelationShip);
            count+=j;
        }
        if(count>pids.length){
            map.put("isAdd",true);
        }else{
            map.put("isAdd",false);
        }
        return map;
    }

    @Override
    public Map deleteRolePermByPids(Integer[] ids) {
        Map map=new HashMap();
        int i=rolePermissionRelationShipDao.deleteRolePerByIds(ids);
        if(i>0){
            map.put("isDelete",true);
        }else{
            map.put("idDelete",false);
        }
        return map;
    }

    @Override
    public RolePermDto getRolePermsByRid(Integer rid) {
        RolePermDto rolePermDto= new RolePermDto();
        Role role=roleDao.getRoleById(rid);
        rolePermDto.setRid(rid);
        rolePermDto.setRolename(role.getRolename());
        RolePermissionRelationShip rolePermissionRelationShip=new RolePermissionRelationShip();
        rolePermissionRelationShip.setRid(rid);
        List<RolePermissionRelationShip> rolePermissionRelationShips=rolePermissionRelationShipDao.getRolePermissionRelationShip(rolePermissionRelationShip);
        Set<Integer> ids=new HashSet<>();
        if(!CollectionUtils.isEmpty(rolePermissionRelationShips)){
            for(RolePermissionRelationShip relationShip:rolePermissionRelationShips){
                ids.add(relationShip.getPid());
            }
        }
        List<Permission> permissions=permissionDao.getPermissionsByIds(ids);
        rolePermDto.setPermissionList(permissions);
        return rolePermDto;
    }


}
