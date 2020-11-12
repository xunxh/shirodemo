package com.cmos.itframe.dao;

import com.cmos.itframe.beans.RolePermissionRelationShip;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePermissionRelationShipDao {
    List<RolePermissionRelationShip> getRolePermissionRelationShip(RolePermissionRelationShip rolePermissionRelationShip);
    int addRolePermRelationShip(RolePermissionRelationShip rolePermissionRelationShip);
    int updateRolePerm(RolePermissionRelationShip rolePermissionRelationShip);
    int deleteRolePerByIds(@Param("ids")Integer[] ids);
}
