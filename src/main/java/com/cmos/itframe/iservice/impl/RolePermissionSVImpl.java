package com.cmos.itframe.iservice.impl;

import com.cmos.itframe.beans.RolePermissionRelationShip;
import com.cmos.itframe.beans.dto.RolePermDto;
import com.cmos.itframe.dao.RolePermissionRelationShipDao;
import com.cmos.itframe.iservice.RolePermissionSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RolePermissionSVImpl implements RolePermissionSV {
    @Autowired
    private RolePermissionRelationShipDao rolePermissionRelationShipDao;


    @Override
    public Map addRolePermRelationShip(RolePermDto rolePermDto) {
        Map map=new HashMap();
        Integer[] pids=rolePermDto.getPids();
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



}
