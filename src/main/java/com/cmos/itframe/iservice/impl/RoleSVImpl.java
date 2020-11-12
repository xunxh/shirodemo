package com.cmos.itframe.iservice.impl;

import com.cmos.itframe.beans.Role;
import com.cmos.itframe.beans.User;
import com.cmos.itframe.dao.RoleDao;
import com.cmos.itframe.iservice.RoleSV;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleSVImpl implements RoleSV {
    @Autowired
    private RoleDao roleDao;

    @Override
    public Map getRoles(String keyWord,Integer page,Integer limit) {
        Map maps=new HashMap();
        List<Role> roleList=roleDao.getRoles(keyWord);
        //角色信息按照等级排序
        Collections.sort(roleList, new Comparator<Role>() {
            @Override
            public int compare(Role o1, Role o2) {
                if (o1.getRoleLevel() > o2.getRoleLevel()) {
                    return 1;
                }
                if (o1.getRoleLevel() == o2.getRoleLevel()) {
                    return 0;
                }
                return -1;
            }
        });
        PageHelper.startPage(page,limit);
        PageInfo<Role> pageInfo=new PageInfo<>(roleList);
        maps.put("code",0);
        maps.put("msg","");
        maps.put("count",roleList.size());
        maps.put("data",pageInfo.getList());
        return maps;
    }

    @Override
    public Map updateRole(Role role) {
        int i = roleDao.updateRole(role);
        Map map = new HashMap();
        if(i>0){
            map.put("isUpdate",true);
        }else{
            map.put("isUpdate",false);
        }
        return map;
    }

    @Override
    public Map deleteRoleById(Integer rid) {
        int i = roleDao.deleteRoleById(rid);
        Map map = new HashMap();
        if(i>0){
            map.put("isDelete","删除成功");
        }else{
            map.put("isDelete","删除失败");
        }
        return map;
    }

    @Override
    public Map addRole(Role role) {
        int i = roleDao.addRole(role);
        Map map = new HashMap();
        if(i>0){
            map.put("isAdd",true);
        }else{
            map.put("isAdd",false);
        }
        return map;
    }

    @Override
    public Role getRoleById(Integer rid) {
        return roleDao.getRoleById(rid);
    }
}
