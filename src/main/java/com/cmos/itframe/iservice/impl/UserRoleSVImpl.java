package com.cmos.itframe.iservice.impl;

import com.cmos.itframe.beans.Role;
import com.cmos.itframe.beans.User;
import com.cmos.itframe.beans.UserRoleRelationShip;
import com.cmos.itframe.beans.dto.UserRoleDto;
import com.cmos.itframe.beans.dto.UserRoleParamDto;
import com.cmos.itframe.dao.RoleDao;
import com.cmos.itframe.dao.UserDao;
import com.cmos.itframe.dao.UserRoleRelationShipDao;
import com.cmos.itframe.iservice.UserRoleSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class UserRoleSVImpl implements UserRoleSV {
    @Autowired
    private UserRoleRelationShipDao userRoleRelationShipDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public Map saveUserRoles(UserRoleDto userRoleDto) throws Exception {
        Map map=new HashMap();
        Integer userId=userRoleDto.getUid();
        Integer[] ids=userRoleDto.getIds();
        List<Integer> idss=new ArrayList<>();
        UserRoleRelationShip ur=new UserRoleRelationShip();
        ur.setUid(userRoleDto.getUid());
        List<UserRoleRelationShip> userRoleRelationShipList1=userRoleRelationShipDao.getUserRoleRelationships(ur);
        if(userRoleRelationShipList1.size()>0){
            for(UserRoleRelationShip userRoleRelationShip:userRoleRelationShipList1){
               idss.add(userRoleRelationShip.getUrid());
            }
            userRoleRelationShipDao.deleteByIds(idss);
        }
        if(ids.length>0){
            for(int j=0;j<ids.length;j++){
                UserRoleRelationShip u=new UserRoleRelationShip();
                u.setUid(userRoleDto.getUid());
                u.setRid(ids[j]);
                List<UserRoleRelationShip> userRoleRelationShipList=userRoleRelationShipDao.getUserRoleRelationships(u);
                if(CollectionUtils.isEmpty(userRoleRelationShipList)){
                    userRoleRelationShipDao.insertUserRole(u);
                }

            }
        }
        return map;
    }

    @Override
    public List<UserRoleRelationShip> getUserRoleRelationships(UserRoleRelationShip userRoleRelationShip) {
        return userRoleRelationShipDao.getUserRoleRelationships(userRoleRelationShip);
    }

    @Override
    public UserRoleParamDto getUserRoles(Integer uid) {
        UserRoleParamDto paramDto=new UserRoleParamDto();
        User user=userDao.getById(uid);
        paramDto.setUserId(user.getUid());
        paramDto.setUsername(user.getUsername());
        List<Role> relationShips=roleDao.getAllRoles();
        paramDto.setUserRoleRelationShips(relationShips);
        return paramDto;
    }
}
