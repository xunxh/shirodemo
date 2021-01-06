package com.itframe.config;


import com.itframe.beans.*;
import com.itframe.beans.Role;
import com.itframe.beans.UserRoleRelationShip;
import com.itframe.beans.dto.RolePermDto;
import com.itframe.iservice.*;
import com.itframe.beans.Permission;
import com.itframe.beans.User;
import com.itframe.iservice.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class MyRealm extends AuthorizingRealm {

    private static final Logger logger= LoggerFactory.getLogger(MyRealm.class);

    @Autowired
    UserSV userSV;

    @Autowired
    UserRoleSV userRoleSV;

    @Autowired
    RoleSV roleSV;

    @Autowired
    RolePermissionSV rolePermissionSV;

    @Autowired
    PermissionSV permissionSV;

    /*
    *@Description:授权
    */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("开始授权..");
        //能进到这里，表示账号已经通过验证了
        User user= (User) principals.getPrimaryPrincipal();
        //获取权限
        UserRoleRelationShip roleRelationShip=new UserRoleRelationShip();
        roleRelationShip.setUid(user.getUid());
        List<UserRoleRelationShip> userRoleRelationShips=userRoleSV.getUserRoleRelationships(roleRelationShip);
        List<Role> roles=new ArrayList<>();
        List<String> rolenames=new ArrayList<>();
        List<Permission> permissions=new ArrayList<>();
        List<String> permnames=new ArrayList<>();
        if(!CollectionUtils.isEmpty(userRoleRelationShips)){
            for(UserRoleRelationShip userRoleRelationShip:userRoleRelationShips){
                roles.add(roleSV.getRoleById(userRoleRelationShip.getRid()));
                for(Role r:roles){
                    rolenames.add(r.getRolename());
                }

            }
            if(!CollectionUtils.isEmpty(roles)){
                for(Role role:roles){
                    RolePermDto rolePermDto=rolePermissionSV.getRolePermsByRid(role.getRid());
                    permissions.addAll(rolePermDto.getPermissionList());
                }
                for(Permission p:permissions){
                    permnames.add(p.getPermname());
                }
            }else{
                throw new AuthorizationException();
            }
        }else{
            throw new AuthorizationException();
        }
        //授权对象
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(rolenames);
        simpleAuthorizationInfo.addStringPermissions(permnames);
        return simpleAuthorizationInfo;
    }

    /*
    *@Description:认证
    */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("开始认证...");
        //获取账号密码
        UsernamePasswordToken token1= (UsernamePasswordToken) token;
        //获取用户名
        String username=token.getPrincipal().toString();
        //获取密码
        String password=new String(token1.getPassword());
//        获取数据库中的密码
        String pwd=userSV.getPasswordByUsername(username);
        User user=userSV.getByUserName(username);
        //判断账号状态：如果是空则账号不存在，不相同就是密码错误
        if(null==pwd || !pwd.equals(password)){
            throw new AccountException("password is wrong");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户
                user.getPassword(), //密码
                ByteSource.Util.bytes(username),
                getName()  //realm name
        );
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("username",username);
        //根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
        //通常需要以下四个参数
        //1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
        //2). credentials: 密码.即从数据库中获取的密码
        //3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
        //4). credentialsSalt: 盐值,这里我使用的是用户名
        //认证信息里存放账号密码  getName()是当前Realm的集成方法，通常返回当前类名：databaseRealm
        return authenticationInfo;
    }
}
