package com.cmos.itframe.iservice;


import com.cmos.itframe.beans.Permission;

import java.util.Map;

public interface PermissionSV {
    Map getAllPermissions(String keyWord,Integer page,Integer limit);
    Map addPermission(Permission permission);
    Map updatePermission(Permission permission);
    Map deletePermissionById(Integer pid);
    Map getUserPerms();
    Permission getPermissionById(Integer pid);
}
