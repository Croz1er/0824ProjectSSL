package com.deer.ljy.config;

import io.buji.pac4j.context.ShiroSessionStore;
import org.pac4j.cas.client.CasClient;
import org.pac4j.cas.config.CasConfiguration;
import org.pac4j.core.config.Config;
import org.pac4j.core.logout.handler.DefaultLogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CasConfig {

    @Value(value = "http://127.0.0.1:8080/cas")
    private String casServerUrl;
    @Value(value = "http://127.0.0.1:8082")
    private String projectUrl;
    @Value(value = "casClient")
    private String clientName;

    /**
     * CAS Server
     * 登录地址设置
     * @return
     */
    @Bean(name="casConfiguration")
    public CasConfiguration casConfig() {
        final CasConfiguration configuration = new CasConfiguration();
        //CAS server登录地址
        configuration.setLoginUrl(casServerUrl + "/login");
        configuration.setAcceptAnyProxy(true);
        configuration.setPrefixUrl(casServerUrl + "/");
        //监控CAS服务端登出，登出后销毁本地session实现双向登出
        DefaultLogoutHandler logoutHandler = new DefaultLogoutHandler();
        logoutHandler.setDestroySession(true);
        configuration.setLogoutHandler(logoutHandler);


        return configuration;
    }

    /**
     * CAS Client
     * 登录成功,回调客户端地址
     * @param casConfig
     * @return
     */
    @Bean(name="casClient")
    public CasClient casClient(CasConfiguration casConfig){
        CasClient casClient = new CasClient(casConfig);
        //客户端回调地址
        casClient.setCallbackUrl(projectUrl + "/callback?client_name=" + clientName);
        casClient.setName(clientName);
        return casClient;
    }

    /**
     * 全局配置
     * @param casClient
     * @return
     */
    @Bean(name = "exPac4jConfig")
    public Config config(@Autowired CasClient casClient, @Autowired ShiroSessionStore shiroSessionStore){
        Config config = new Config(casClient);
        config.setSessionStore(shiroSessionStore);
        return config;
    }

    /**
     * 自定义Session存储,比如存到redis中
     * @return
     */
    @Bean(name = "shiroSessionStore")
    public ShiroSessionStore shiroSessionStore(){
        return new ShiroSessionStore();
    }
}
