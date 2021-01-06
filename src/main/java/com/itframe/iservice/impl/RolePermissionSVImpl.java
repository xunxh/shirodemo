package com.itframe.iservice.impl;

import com.itframe.beans.Permission;
import com.itframe.beans.Role;
import com.itframe.beans.RolePermissionRelationShip;
import com.itframe.beans.dto.RPDto;
import com.itframe.beans.dto.RolePermDto;
import com.itframe.dao.PermissionDao;
import com.itframe.dao.RoleDao;
import com.itframe.dao.RolePermissionRelationShipDao;
import com.itframe.iservice.RolePermissionSV;
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
    public Map updateRolePermByPids(RPDto permDto) {
        Map map=new HashMap();
        Integer[] ids=permDto.getIds();
        List<Integer> idss=new ArrayList<>();
        RolePermissionRelationShip rp=new RolePermissionRelationShip();
        rp.setRid(permDto.getRid());
        List<RolePermissionRelationShip> rolePermissionRelationShips=rolePermissionRelationShipDao.getRolePermissionRelationShip(rp);
        if(rolePermissionRelationShips.size()>0){
            for(RolePermissionRelationShip r:rolePermissionRelationShips){
                idss.add(r.getRpid());
            }
            rolePermissionRelationShipDao.deleteRolePerByIds(idss);
        }
        for(int i=0;i<ids.length;i++){
            RolePermissionRelationShip relationShip=new RolePermissionRelationShip();
            relationShip.setRid(permDto.getRid());
            relationShip.setPid(ids[i]);
            List<RolePermissionRelationShip> rolePermissionRelationShip = rolePermissionRelationShipDao.getRolePermissionRelationShip(relationShip);
            if(CollectionUtils.isEmpty(rolePermissionRelationShip)){
                rolePermissionRelationShipDao.addRolePermRelationShip(relationShip);
            }
        }

        return map;
    }

    @Override
    public RolePermDto getRolePermsByRid(Integer rid) {
        RolePermDto rolePermDto= new RolePermDto();
        List<Permission> permissions=permissionDao.getAllPermissions(null);

        Role role=roleDao.getRoleById(rid);
        rolePermDto.setRid(rid);
        rolePermDto.setRolename(role.getRolename());
        if(role.getRoleLevel()==1){
            rolePermDto.setPermissionList(permissions);
        }else{
            RolePermissionRelationShip rolePermissionRelationShip=new RolePermissionRelationShip();
            rolePermissionRelationShip.setRid(rid);
            List<RolePermissionRelationShip> rolePermissionRelationShips=rolePermissionRelationShipDao.getRolePermissionRelationShip(rolePermissionRelationShip);
            Set<Integer> ids=new HashSet<>();
            if(!CollectionUtils.isEmpty(rolePermissionRelationShips)){
                for(RolePermissionRelationShip relationShip:rolePermissionRelationShips){
                    ids.add(relationShip.getPid());
                }
            }
            rolePermDto.setPermissionList(permissionDao.getPermissionsByIds(ids));
        }

        return rolePermDto;
    }


}
