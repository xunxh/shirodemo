package com.cmos.itframe.iservice;

import com.cmos.itframe.beans.UserRoleRelationShip;

import java.util.List;

public interface UserRoleSV {
    List<UserRoleRelationShip> getUserRoleRelationships(UserRoleRelationShip userRoleRelationShip);
}
