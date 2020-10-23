package com.cmos.itframe.shiro_demo.itframe.dao;

import com.cmos.itframe.shiro_demo.itframe.beans.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    List<Role> findRoleListByUserId(@Param("userId") int userId);
}
