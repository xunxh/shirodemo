package com.itframe.dao;

import com.itframe.beans.UserRoleRelationShip;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleRelationShipDao {
    List<UserRoleRelationShip> getUserRoleRelationships(UserRoleRelationShip userRoleRelationShip);
    int deleteByIds(@Param("ids") List<Integer> ids);
    int insertUserRole(UserRoleRelationShip userRoleRelationShips);
}
