package com.itframe.iservice.impl;

import com.itframe.beans.*;
import com.itframe.beans.*;
import com.itframe.beans.dto.PermDto;
import com.itframe.dao.*;
import com.itframe.dao.*;
import com.itframe.iservice.PermissionSV;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class PermissionSVImpl implements PermissionSV {

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private HttpSession session;

    @Autowired
    private UserRoleRelationShipDao userRoleRelationShipDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RolePermissionRelationShipDao rolePermissionRelationShipDao;

    @Override
    public Map getAllPermissions(String keyWord, Integer page, Integer limit) {
        Map maps=new HashMap();
        List<Permission> permissions=permissionDao.getAllPermissions(keyWord);
        PageHelper.startPage(page,limit);
        PageInfo<Permission> pageInfo=new PageInfo<>(permissions);
        maps.put("code",0);
        maps.put("msg","");
        maps.put("count",permissions.size());
        maps.put("data",pageInfo.getList());
        return maps;
    }

    public List<Permission> getPermission(){
        return permissionDao.getAllPermissions(null);
    }

    @Override
    public Map addPermission(Permission permission) {
        int i = permissionDao.addPermission(permission);
        Map map = new HashMap();
        if(i>0){
            map.put("isAdd",true);
        }else{
            map.put("isAdd",false);
        }
        return map;
    }

    @Override
    public Map updatePermission(Permission permission) {
        int i = permissionDao.updatePermission(permission);
        Map map = new HashMap();
        if(i>0){
            map.put("isUpdate",true);
        }else{
            map.put("isUpdate",false);
        }
        return map;
    }

    @Override
    public Map deletePermissionById(Integer pid) {
        int i = permissionDao.deletePermissionById(pid);
        Map map = new HashMap();
        if(i>0){
            map.put("isDelete","删除成功");
        }else{
            map.put("isDelete","删除失败");
        }
        return map;
    }

    //得到用户对应的初始化菜单
    @Override
    public Map getUserPerms() {
        //获取当前登录的用户
        String username= (String) session.getAttribute("username");
        User user=userDao.getByUserName(username);
        //得到当前用户对应的角色
        UserRoleRelationShip roleRelationShip=new UserRoleRelationShip();
        roleRelationShip.setUid(user.getUid());
//        roleRelationShip.setUid(2);
        List<UserRoleRelationShip> userRoleRelationShips= userRoleRelationShipDao.getUserRoleRelationships(roleRelationShip);
        Set<Integer> ids=new HashSet<>();
        List<Permission> permissions=new ArrayList<>();
        List<PermDto> permDtos=new ArrayList<>();
        Map map=new HashMap();
        if(!CollectionUtils.isEmpty(userRoleRelationShips)){
            //得到角色id
            for(int i=0;i<userRoleRelationShips.size();i++){
                ids.add(userRoleRelationShips.get(i).getRid());
            }
            List<Role> roleList=roleDao.findRoleListByIds(ids);
            Role roleMax=new Role();
            if(CollectionUtils.isEmpty(roleList)){
                return map;
            }
            //得到最高级别的角色
            if(roleList.size()>1){
                for(int i=0;i<roleList.size()-2;i++){
                    roleMax=roleList.get(i).getRoleLevel()<=roleList.get(i+1).getRoleLevel()?roleList.get(i):roleList.get(i+1);
                }
            }else{
                roleMax=roleList.get(0);
            }

            RolePermissionRelationShip rolePermissionRelationShip=new RolePermissionRelationShip();
            rolePermissionRelationShip.setRid(roleMax.getRid());
            //得到角色拥有的权限信息
            List<RolePermissionRelationShip> rolePermissionRelationShips=rolePermissionRelationShipDao.getRolePermissionRelationShip(rolePermissionRelationShip);
            if(!CollectionUtils.isEmpty(rolePermissionRelationShips)){
                Set<Integer> pids=new HashSet<>();
                for(int j=0;j<rolePermissionRelationShips.size();j++){
                    pids.add(rolePermissionRelationShips.get(j).getPid());
                }
                permissions=permissionDao.getPermissionsByIds(pids);
                List<Permission> b=new ArrayList<>();
                for(Permission permission:permissions){
                    if(permission.getTypes()!=1){
                        b.add(permission);
                    }
                }
                permissions.removeAll(b);
                for(int i=0;i<permissions.size();i++){
                    PermDto permDto=new PermDto();
                    Permission a=permissions.get(i);
                    permDto.setId(a.getPid());
                    permDto.setName(a.getPermname());
                    permDto.setHref(a.getUrl());
                    List<PermDto> permDtoList=new ArrayList<>();
                    //获取子菜单
                    for(Permission permission:permissions){
                        if(permission.getParentId()==a.getPid()){
                            PermDto p=new PermDto();
                            p.setId(permission.getPid());
                            p.setHref(permission.getUrl());
                            p.setName(permission.getPermname());
                            permDtoList.add(p);
                        }
                    }
                    permDto.setChildren(permDtoList);
                    if(permDto.getChildren()!=null && permDto.getChildren().size()!=0){
                        permDtos.add(permDto);
                    }
                }
            }
        }
        map.put("code",0);
        map.put("msg","");
        map.put("count",permDtos.size());
        map.put("data",permDtos);

        return map;
    }

    @Override
    public Permission getPermissionById(Integer pid) {
        return permissionDao.getPermissionById(pid);
    }
}
