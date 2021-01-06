package com.itframe.dao;

import com.itframe.beans.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface PermissionDao {
    List<Permission> getAllPermissions(@Param("keyWord")String keyWord);
    int addPermission(Permission permission);
    int updatePermission(Permission permission);
    int deletePermissionById(@Param("pid")Integer pid);
    Permission getPermissionById(@Param("pid")Integer pid);
    List<Permission> getPermissionsByIds(@Param("ids")Set<Integer> ids);
}
