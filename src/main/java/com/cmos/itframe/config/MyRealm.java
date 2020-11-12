package com.cmos.itframe.config;


import com.cmos.itframe.beans.User;
import com.cmos.itframe.iservice.UserSV;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserSV userSV;

    @Autowired
    private HttpSession session;
    /*
    *@Description:授权
    */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //能进到这里，表示账号已经通过验证了
        String userName= (String) principals.getPrimaryPrincipal();
        //获取权限
        //List<String> permissions=userSV.listPermissions(userName);
        //授权对象
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        //把通过DAO获取到的角色和权限放进去
        //simpleAuthorizationInfo.setStringPermissions(new HashSet<>(permissions));
        return simpleAuthorizationInfo;
    }

    /*
    *@Description:认证
    */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取账号密码
        UsernamePasswordToken token1= (UsernamePasswordToken) token;
        //获取用户名
        String username=token.getPrincipal().toString();
        //获取密码
        String password=new String(token1.getPassword());
        //生成盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);
        //加密
        SimpleHash simpleHash=new SimpleHash("MD5",password,credentialsSalt,1);
        //得到加密后的密码
        password=simpleHash.toString();
        //获取数据库中的密码
        User user=userSV.getByUserName(username);
        //判断账号状态：如果是空则账号不存在，不相同就是密码错误
        if(null==user.getPassword() || !user.getPassword().equals(password)){
            return null;
        }
        session.setAttribute("user",user);
        //根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
        //通常需要以下四个参数
        //1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
        //2). credentials: 密码.即从数据库中获取的密码
        //3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
        //4). credentialsSalt: 盐值,这里我使用的是用户名

        //认证信息里存放账号密码  getName()是当前Realm的集成方法，通常返回当前类名：databaseRealm
        return new SimpleAuthenticationInfo(username,password,credentialsSalt,getName());
    }
}
