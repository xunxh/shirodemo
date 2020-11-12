package com.cmos.itframe.iservice.impl;

import com.cmos.itframe.beans.UserRoleRelationShip;
import com.cmos.itframe.dao.UserRoleRelationShipDao;
import com.cmos.itframe.iservice.UserRoleSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleSVImpl implements UserRoleSV {
    @Autowired
    private UserRoleRelationShipDao userRoleRelationShipDao;
    @Override
    public List<UserRoleRelationShip> getUserRoleRelationships(UserRoleRelationShip userRoleRelationShip) {
        return userRoleRelationShipDao.getUserRoleRelationships(userRoleRelationShip);
    }
}
