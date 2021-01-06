package com.itframe.iservice;

import com.itframe.beans.UserRoleRelationShip;
import com.itframe.beans.dto.UserRoleDto;
import com.itframe.beans.dto.UserRoleParamDto;

import java.util.List;
import java.util.Map;

public interface UserRoleSV {
    Map saveUserRoles(UserRoleDto userRoleDto) throws Exception;
    List<UserRoleRelationShip> getUserRoleRelationships(UserRoleRelationShip userRoleRelationShip);
    UserRoleParamDto getUserRoles(Integer uid);
}
