package com.cmos.itframe.shiro_demo.itframe.dao;

import com.cmos.itframe.shiro_demo.itframe.beans.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionDao {
    List<Permission> findPermissionListByRoleId(@Param("roleId") int roleId);
}
