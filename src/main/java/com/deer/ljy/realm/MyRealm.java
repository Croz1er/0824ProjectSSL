package com.deer.ljy.realm;

import io.buji.pac4j.realm.Pac4jRealm;
import io.buji.pac4j.subject.Pac4jPrincipal;
import io.buji.pac4j.token.Pac4jToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.pac4j.core.profile.CommonProfile;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class MyRealm extends Pac4jRealm {

    /**
     * 用户认证
     * @param token
     * @return
     * @throws AuthenticationException
     */

    @Resource
    private DataSource dataSource;


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证开启");

        final Pac4jToken pac4jToken = (Pac4jToken) token;
        final List<CommonProfile> commonProfileList = pac4jToken.getProfiles();
        final CommonProfile commonProfile = commonProfileList.get(0);
        System.out.println("单点登录返回的信息=====>" + commonProfile.toString());
        System.out.println("用户名为********"+commonProfile.getId());
        final Pac4jPrincipal principal = new Pac4jPrincipal(commonProfileList, getPrincipalNameAttribute());
        final PrincipalCollection principalCollection = new SimplePrincipalCollection(principal, getName());
        return new SimpleAuthenticationInfo(principalCollection, commonProfileList.hashCode());
    }

    /**
     * 开启授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权开启"+principals.asList());
        System.out.println("授权开启"+principals.asSet());
        System.out.println("授权开启"+principals.getRealmNames());
        System.out.println("授权开启"+principals);



        if (principals == null){
            throw new AuthorizationException("角色为空异常");
        }
        //获取角色的用户名
        System.out.println(this.getAvailablePrincipal(principals));
        String username = null;
        try {
            Pac4jPrincipal pac4jPrincipal = (Pac4jPrincipal) this.getAvailablePrincipal(principals);
            username = pac4jPrincipal.getProfile().getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("11223344"+username);

        Connection connection = null;
        Set<String> rolename = null;
        Set<String> permission = null;

        try {
            connection = this.dataSource.getConnection();
            //获取角色
            String sql = "select roleCode from au_role where id = " +
                    "(select roleId from au_user where username = ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            ResultSet resultSet1 = statement.executeQuery();
            while (resultSet1.next()){

                //将获取的rolenurl塞入集合中
                String rolecode = resultSet1.getString("rolecode");
                rolename = new HashSet<>();
                rolename.add(rolecode);
            }
            System.out.println("获取的角色"+rolename);

            //获取角色的权限
            sql = "Select funcUrl from au_function where id in " +
                    "(select functionId from au_authority where roleId = " +
                    "(select roleId from au_user where username = ?))";
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            ResultSet resultSet = statement.executeQuery();
            permission = new HashSet<>();
            while (resultSet.next()){
                //将获取的
                String funcUrl = resultSet.getString("funcUrl");
                permission.add(funcUrl);
                System.out.println(funcUrl);
            }
            System.out.println("获取的权限"+permission);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(rolename);
        info.setStringPermissions(permission);
        return info;
    }
}
