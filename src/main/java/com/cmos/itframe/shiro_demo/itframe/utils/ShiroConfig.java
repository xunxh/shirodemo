package com.cmos.itframe.shiro_demo.itframe.utils;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //创建ShiroFilterFactoryBean过滤器
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("mySecurityManager")SecurityManager manager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        /*
        * 设置过滤规则
        */
        Map map=new HashMap();
        /*
        * anon  代表匿名可访问   即不用登陆就可以访问  不过滤
        * authc  代表登录后才能访问  需要认证  会被过滤
        * user: 如果使用rememberMe的功能可以直接访问
        * perms:该资源必须得到资源权限才可以访问
        * role:该资源必须得到角色权限才能访问
        * 支持通配符 *
        * 注意拦截规则  一个一个配置
        */
        map.put("/login","anon");

        shiroFilterFactoryBean.setSecurityManager(manager);
        return shiroFilterFactoryBean;
    }

    //创建安全管理器
    @Bean("mySecurityManager")
    public SessionsSecurityManager securityManager(@Qualifier("myRealm") MyRealm myRealm){
        DefaultSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }

    //创建自定义的Realm
    @Bean("myRealm")
    public MyRealm getMyRealm(@Qualifier("hashedCredentialsMatcher")HashedCredentialsMatcher matcher){
        MyRealm myRealm=new MyRealm();
        //替换当前Realm的credentialsMatcher属性
        myRealm.setCredentialsMatcher(matcher);
        return myRealm;
    }

    /**
     *  替换当前 Realm 的 credentialsMatcher 属性.
     *  直接使用 HashedCredentialsMatcher 对象, 并设置加密算法即可.
     *  密码校验规则HashedCredentialsMatcher
     *  这个类是为了对密码进行编码的
     *  防止密码在数据库中明码表示,当然在登录认证的时候,
     *  这个类也负责对form里输入的密码进行编码
     *  处理认证匹配处理器
     * @return
     */

    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //指定加密方式为MD5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //加密次数
        credentialsMatcher.setHashIterations(1);
        return credentialsMatcher;
    }
}
