package com.deer.ljy.realm;

import io.buji.pac4j.realm.Pac4jRealm;
import io.buji.pac4j.subject.Pac4jPrincipal;
import io.buji.pac4j.token.Pac4jToken;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.pac4j.core.profile.CommonProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import java.util.List;


@Configuration
public class MyRealm extends Pac4jRealm {
    @Autowired
    private DataSource dataSource;
    /**
     * 认证,使用CAS返回ticket认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        final Pac4jToken pac4jToken = (Pac4jToken) authenticationToken;
        final List<CommonProfile> commonProfileList = pac4jToken.getProfiles();
        final CommonProfile commonProfile = commonProfileList.get(0);
        System.out.println("单点登录返回的信息=====>" + commonProfile.toString());
        System.out.println("用户名为********"+commonProfile.getId());
        final Pac4jPrincipal principal = new Pac4jPrincipal(commonProfileList, getPrincipalNameAttribute());
        final PrincipalCollection principalCollection = new SimplePrincipalCollection(principal, getName());
        return new SimpleAuthenticationInfo(principalCollection, commonProfileList.hashCode());
    }

    /**
     * 授权,使用shiro的授权方式
     * 应该获取CAS返回用户信息,去数据库中查询相应权限信息,权限管理交由shiro
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("======>doGetAuthorizationInfo");
        SimpleAuthorizationInfo authInfo = new SimpleAuthorizationInfo();
        //测试用
        authInfo.addStringPermission("user:select");
        //Pac4jPrincipal principal = (Pac4jPrincipal)this.getAvailablePrincipal(principals);
        //System.out.println("----------------------"+principal.getProfile().getId());
        //try {
        //自定义查询权限方式
        //System.out.println(dataSource.getConnection());
        //}catch (Exception e){
        // e.printStackTrace();
        //}
        return authInfo;
    }
}
