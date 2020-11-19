package com.cmos.itframe.iservice;

import com.cmos.itframe.beans.RolePermissionRelationShip;
import com.cmos.itframe.beans.dto.RolePermDto;

import java.util.Map;

public interface RolePermissionSV {
    Map addRolePermRelationShip(RolePermDto rolePermDto);
    Map deleteRolePermByPids(Integer[] ids);
    RolePermDto getRolePermsByRid(Integer rid);
}
