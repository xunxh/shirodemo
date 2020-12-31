package com.cmos.itframe.iservice;

import com.cmos.itframe.beans.UserRoleRelationShip;
import com.cmos.itframe.beans.dto.UserRoleDto;
import com.cmos.itframe.beans.dto.UserRoleParamDto;

import java.util.List;
import java.util.Map;

public interface UserRoleSV {
    Map saveUserRoles(UserRoleDto userRoleDto) throws Exception;
    List<UserRoleRelationShip> getUserRoleRelationships(UserRoleRelationShip userRoleRelationShip);
    UserRoleParamDto getUserRoles(Integer uid);
}
