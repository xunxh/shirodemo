package com.itframe.iservice.impl;

import com.itframe.beans.Role;
import com.itframe.beans.User;
import com.itframe.beans.UserRoleRelationShip;
import com.itframe.beans.dto.UserRoleDto;
import com.itframe.beans.dto.UserRoleParamDto;
import com.itframe.dao.RoleDao;
import com.itframe.dao.UserDao;
import com.itframe.dao.UserRoleRelationShipDao;
import com.itframe.iservice.UserRoleSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
        //角色id
        Integer[] ids=userRoleDto.getIds();
        List<Integer> idss=new ArrayList<>();
        UserRoleRelationShip ur=new UserRoleRelationShip();
        ur.setUid(userRoleDto.getUid());
        //当前用户对应的角色关系
        List<UserRoleRelationShip> userRoleRelationShipList1=userRoleRelationShipDao.getUserRoleRelationships(ur);
        if(userRoleRelationShipList1.size()>0){
            for(UserRoleRelationShip userRoleRelationShip:userRoleRelationShipList1){
               idss.add(userRoleRelationShip.getUrid());
            }
            userRoleRelationShipDao.deleteByIds(idss);
        }
        for(int j=0;j<ids.length;j++){
            UserRoleRelationShip u=new UserRoleRelationShip();
            u.setUid(userRoleDto.getUid());
            u.setRid(ids[j]);
            List<UserRoleRelationShip> userRoleRelationShipList=userRoleRelationShipDao.getUserRoleRelationships(u);
            if(CollectionUtils.isEmpty(userRoleRelationShipList)){
                userRoleRelationShipDao.insertUserRole(u);
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
