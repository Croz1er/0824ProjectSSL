package com.deer.ljy.provider;

import org.apache.ibatis.jdbc.SQL;

public class FuncProvider {

    public String selectAllFuncByRoleId(Integer roleId){
        SQL sql = new SQL();

        sql.SELECT("*").FROM("au_function");
        if (roleId !=null){
            sql.WHERE("id IN (SELECT functionid FROM au_authority WHERE roleId = #{roleId})").ORDER_BY("id asc");
        }
        System.out.println(sql.toString());
        return sql.toString();
    }
}
