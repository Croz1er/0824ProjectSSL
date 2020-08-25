package com.deer.ljy.provider;

import com.deer.ljy.pojo.User;
import org.apache.ibatis.jdbc.SQL;

public class UserProvider {

    public String selectAll(final User user){
        SQL sql = new SQL();
        sql.SELECT("*").FROM("au_user");
        if (!user.getRoleName().equals("管理员")){
            sql.WHERE("referId=#{referId}");
        }
        if (user.getUsername()!=null){
            sql.WHERE("username like #{username}");
        }

        return sql.toString();
    }

}
