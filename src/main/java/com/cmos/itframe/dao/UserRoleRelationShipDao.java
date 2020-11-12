package com.cmos.itframe.dao;

import com.cmos.itframe.beans.UserRoleRelationShip;

import java.util.List;

public interface UserRoleRelationShipDao {
    List<UserRoleRelationShip> getUserRoleRelationships(UserRoleRelationShip userRoleRelationShip);
}
