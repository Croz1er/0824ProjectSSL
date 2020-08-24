package com.deer.ljy.config;


import com.deer.ljy.realm.MyRealm;
import io.buji.pac4j.filter.CallbackFilter;
import io.buji.pac4j.filter.LogoutFilter;
import io.buji.pac4j.filter.SecurityFilter;
import io.buji.pac4j.subject.Pac4jSubjectFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.pac4j.core.config.Config;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class SpringShiroConfig {

    /**
     * 开启Shiro注解(如@RequiresRoles,@RequiresPermissions),
     * 需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)
     * @return
     */

    @Value("casClient")
    private String clientName;


    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);

        return defaultAdvisorAutoProxyCreator;
    }

    /**
     * 开启aop注解支持
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor beginAOP(@Autowired SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor sourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        sourceAdvisor.setSecurityManager(securityManager);
        return sourceAdvisor;
    }


    /**
     * filter工厂
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Autowired SecurityManager securityManager,
                                                         @Autowired Config exPac4jConfig,
                                                         @Autowired Pac4jSubjectFactory pac4jSubjectFactory,
                                                         @Autowired MyRealm myRealm){
        System.out.println( "shiro Filter....." );
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("http://127.0.0.1:8082/html/login.html");

        //1.设置认证管理器使用的Realm和认证交由CAS处理
        DefaultWebSecurityManager sm = (DefaultWebSecurityManager) securityManager;
        //增加pac4jSubjectFactory,认证管理交由Cas
        sm.setSubjectFactory(pac4jSubjectFactory);
        //认证和授权
        sm.setRealm(myRealm);
        shiroFilterFactoryBean.setSecurityManager(sm);

        //2.向shiro过滤器中添加额外的CAS过滤器
        Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();

        // cas 资源认证过滤器
        SecurityFilter securityFilter = new SecurityFilter();
        securityFilter.setConfig(exPac4jConfig);
        securityFilter.setClients(clientName);
        filters.put("securityFilter", securityFilter);
        //cas 认证后回调过滤器
        CallbackFilter callbackFilter = new CallbackFilter();
        callbackFilter.setConfig(exPac4jConfig);
        filters.put("callbackFilter", callbackFilter);
        shiroFilterFactoryBean.setFilters(filters);
        //本地登出同步登出CAS服务器
        LogoutFilter pac4jCentralLogout = new LogoutFilter();
        pac4jCentralLogout.setConfig(exPac4jConfig);
        pac4jCentralLogout.setCentralLogout(true);
        pac4jCentralLogout.setLocalLogout(true);
        filters.put("logoutFilter", pac4jCentralLogout);




        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();

        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/cas/logout", "logoutFilter");//CAS登出
        filterChainDefinitionMap.put("/callback", "callbackFilter");//CAS认证成功,回调原访问路径
        filterChainDefinitionMap.put("/login.do", "anon");
        filterChainDefinitionMap.put("/captcha.do", "anon");
        filterChainDefinitionMap.put("/tologin.do", "anon");
        filterChainDefinitionMap.put("/session.do", "anon");
        filterChainDefinitionMap.put("/goods/find.do", "anon");
        //filterChainDefinitionMap.put("/user/remember.do", "user");
        filterChainDefinitionMap.put("/**", "securityFilter");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 使用自定义认证及授权逻辑
     * @return
     */
    @Bean(name = "authorizer")
    public MyRealm pac4jRealm(){
        return new MyRealm();
    }



    /**
     * 使用 pac4j 的 subjectFactory
     * @return
     */
    @Bean
    public Pac4jSubjectFactory subjectFactory(){
        return new Pac4jSubjectFactory();
    }



}
