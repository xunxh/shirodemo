package com.itframe.iservice;

import com.itframe.beans.Role;

import java.util.List;
import java.util.Map;


public interface RoleSV {
    Map getRoles(String keyWord,Integer page,Integer limit);
    Map updateRole(Role role);
    Map deleteRoleById(Integer rid);
    Map addRole(Role role);
    Role getRoleById(Integer rid);
    List<Role> getRoleIdAndRoleName();
}
