package com.itframe.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {
    private static final Logger logger= LoggerFactory.getLogger(ShiroConfig.class);
    /**
     * 创建ShiroFilterFactoryBean过滤器
     * 配置拦截器路径和放行路径
     * @param manager  安全管理器
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("mySecurityManager")SecurityManager manager) {
        //shiro过滤器工厂类
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(manager);
//        shiroFilterFactoryBean.setLoginUrl("/common/login.html");
        //拦截器---map集合
        Map<String,String> map=new LinkedHashMap<>();
        /*
        * anon  代表匿名可访问   即不用登陆就可以访问  不过滤
        * authc  代表登录后才能访问  需要认证  会被过滤
        * user: 如果使用rememberMe的功能可以直接访问
        * perms:该资源必须得到资源权限才可以访问
        * role:该资源必须得到角色权限才能访问
        * 支持通配符 *
        * 注意拦截规则  一个一个配置
        */
        //配置退出过滤器，其中的推出代码shiro已经替我们实现了
        map.put("/login*","anon");
        map.put("/permission/**","authc");
        map.put("/user/**","authc");
        map.put("/role/**","authc");
        map.put("/**","authc");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
//        shiroFilterFactoryBean.setUnauthorizedUrl("/common/noPermissionError.html");
        logger.info("===shiroFilterFacyoryBean注册完成===");
        return shiroFilterFactoryBean;
    }

    //创建安全管理器,注入Realm域
    @Bean("mySecurityManager")
    public SessionsSecurityManager securityManager(@Qualifier("myRealm") MyRealm myRealm){
        DefaultSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        logger.info("===securityManager注册完成===");
        return securityManager;
    }

    /**
     * Credentials：凭证
     * 配置realm域，注入密码比较器
     * @param
     * @return
     */
    @Bean("myRealm")
    public MyRealm getMyRealm(){
        MyRealm myRealm=new MyRealm();
        //替换当前Realm的credentialsMatcher属性
        logger.info("====myRealm注册完成===");
        return myRealm;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * *
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * *
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
     * * @return
     */
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("mySecurityManager")SecurityManager manager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(manager);
        return authorizationAttributeSourceAdvisor;
    }

    //可在页面上使用shiro标签实现权限控制
    @Bean(name = "shiroDialect")
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }


}
