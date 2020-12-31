package com.cmos.itframe.iservice.impl;

import com.cmos.itframe.beans.Role;
import com.cmos.itframe.beans.User;
import com.cmos.itframe.beans.UserRoleRelationShip;
import com.cmos.itframe.beans.dto.UserDto;
import com.cmos.itframe.dao.RoleDao;
import com.cmos.itframe.dao.UserDao;
import com.cmos.itframe.dao.UserRoleRelationShipDao;
import com.cmos.itframe.iservice.UserSV;
import com.cmos.itframe.utils.PageUtil;
import com.cmos.itframe.utils.PwdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class UserSVImpl implements UserSV {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserRoleRelationShipDao userRoleRelationShipDao;

    @Override
    public User getByUserName(String username) {
        return userDao.getByUserName(username);
    }

    @Override
    public String getPasswordByUsername(String username) {
        return userDao.getPasswordByUsername(username);
    }

    //查询单个用户信息
    @Override
    public User getUserById(Integer uid) {
        return userDao.getById(uid);
    }

    //添加用户信息
    @Override
    public Map addUser(User user) {
        String str = PwdUtil.getPwd(user.getPassword(), user.getUsername());
        user.setPassword(str);
        int i = userDao.addUser(user);
        Map map = new HashMap();
        if(i>0){
            map.put("isAdd",true);
        }else{
            map.put("isAdd",false);
        }
        return map;
    }

    //修改用户信息
    @Override
    public Map updateUser(User user) {
        String str = PwdUtil.getPwd(user.getPassword(), user.getUsername());
        user.setPassword(str);
        int i = userDao.updateUser(user);
        Map map = new HashMap();
        if(i>0){
            map.put("isUpdate",true);
        }else{
            map.put("isUpdate",false);
        }

        return map;
    }

    //删除用户
    @Override
    public Map deleteUser(Integer uid) {
        int i = userDao.deleteById(uid);
        Map map = new HashMap();
        if(i>0){
            map.put("isDelete","删除成功");
        }else{
            map.put("isDelete","删除失败");
        }
        return map;
    }

    //展示用户信息
    @Override
    public Map getUsers(Integer page, Integer limit, String keyWord){
        Map maps=new HashMap();
        //创建userDtos集合
        List<UserDto> userDtos=new ArrayList<>();
        //先根据模糊查询得到用户信息
        List<User> users=userDao.getByKeyWord(keyWord);
        //得到所有的角色信息
        List<Role> roles=roleDao.getAllRoles();
        Role role1=new Role();
        //把角色信息放入map集合中， key：roleId, value:role
        Map<Integer,Role> map=new HashMap<>();
        for(Role role:roles){
            if(!map.containsKey(role.getRid())){
                map.put(role.getRid(),role);
            }
        }
        PageHelper.startPage(page,limit);
        PageInfo<User> pageInfo=new PageInfo<>(users);
        PageInfo<UserDto> userDtoPageInfo= PageUtil.PageInfo2PageInfoVo(pageInfo);
        for(int i=0;i<users.size();i++) {
            //声明一个userDto变量
            UserDto userDto=new UserDto();
            //把user的值赋给userDto
            userDto.setUid(users.get(i).getUid());
            userDto.setUsername(users.get(i).getUsername());
            userDto.setRealName(users.get(i).getRealName());
            userDto.setEmail(users.get(i).getEmail());
            userDto.setMobile(users.get(i).getMobile());
            userDto.setStatus(users.get(i).getStatus());
            userDto.setRemark(users.get(i).getRemark());
            //声明一个roleList集合，用来存放每个用户对应的角色信息
            List<Role> roleList = new ArrayList<>();
            //声明一个用户角色关系变量
            UserRoleRelationShip userRoleRelationShip = new UserRoleRelationShip();
            //给变量赋值
            userRoleRelationShip.setUid(users.get(i).getUid());
            //通过userRole查询该用户对应的角色关系
            List<UserRoleRelationShip> userRoleRelationShips = userRoleRelationShipDao.getUserRoleRelationships(userRoleRelationShip);
            if (!CollectionUtils.isEmpty(userRoleRelationShips)) {
                for (int j = 0; j < userRoleRelationShips.size(); j++) {
                    role1 = map.get(userRoleRelationShips.get(j).getRid());
                    if (!roleList.contains(role1)) {
                        roleList.add(role1);
                    }
                }
            }
            if(roleList.size()==0){
                Role role=new Role();
                role.setRolename(" ");
                roleList.add(role);
            }
            userDto.setRoles(roleList);
            userDtos.add(userDto);
        }
        /**优先显示有角色的用户
         * 0 不变
         * 1 升序 由小到大
         * -1  降序  由大到小
         */
       if(!CollectionUtils.isEmpty(userDtos)){
           userDtos.sort((o1,o2) ->{
               if(!CollectionUtils.isEmpty(o1.getRoles())){
                   if(!CollectionUtils.isEmpty(o2.getRoles())){
                       int diff=o1.getRoles().size()-o2.getRoles().size();
                       if(diff>0){
                            return -1;
                       }else if(diff < 0){
                           return 1;
                       }
                       return 0;
                   }else{
                       return -1;
                   }
               }else if(!CollectionUtils.isEmpty(o2.getRoles())){
                   return 1;
               }else{
                   return 0;
               }
           });
       }
       for(UserDto userDto1:userDtos){
           userDtoPageInfo.getList().add(userDto1);
       }
        maps.put("code",0);
        maps.put("msg","");
        maps.put("count",users.size());
        maps.put("data",userDtoPageInfo.getList());
        return maps;
    }
}
