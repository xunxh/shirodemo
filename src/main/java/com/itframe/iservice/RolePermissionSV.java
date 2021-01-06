package com.itframe.iservice;

import com.itframe.beans.dto.RPDto;
import com.itframe.beans.dto.RolePermDto;

import java.util.Map;

public interface RolePermissionSV {
    Map addRolePermRelationShip(RolePermDto rolePermDto);
    Map updateRolePermByPids(RPDto rolePermDto);
    RolePermDto getRolePermsByRid(Integer rid);
}
