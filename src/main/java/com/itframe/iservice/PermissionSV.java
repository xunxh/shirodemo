package com.itframe.iservice;


import com.itframe.beans.Permission;

import java.util.List;
import java.util.Map;

public interface PermissionSV {
    Map getAllPermissions(String keyWord,Integer page,Integer limit);
    Map addPermission(Permission permission);
    Map updatePermission(Permission permission);
    Map deletePermissionById(Integer pid);
    Map getUserPerms();
    List<Permission> getPermission();
    Permission getPermissionById(Integer pid);
}
