package com.cmos.itframe.dao;

import com.cmos.itframe.beans.UserRoleRelationShip;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface UserRoleRelationShipDao {
    List<UserRoleRelationShip> getUserRoleRelationships(UserRoleRelationShip userRoleRelationShip);
    void deleteByIds(@Param("ids") List<Integer> ids);
    int insertUserRole(UserRoleRelationShip userRoleRelationShips);
}
