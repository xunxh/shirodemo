package com.cmos.itframe.dao;

import com.cmos.itframe.beans.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    List<Role> findRoleListByIds(@Param("ids")Set<Integer> ids);
    List<Role> getRoles(@Param("keyWord")String keyWord);
    int updateRole(Role role);
    int deleteRoleById(@Param("rid") Integer rid);
    int addRole(Role role);
    Role getRoleById(@Param("rid")Integer rid);
    List<Role> getAllRoles();
    List<Role> getRoleIdAndRoleName();
}
