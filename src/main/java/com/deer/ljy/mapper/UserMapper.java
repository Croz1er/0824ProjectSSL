package com.deer.ljy.mapper;

import com.deer.ljy.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from au_user where username = #{username}")
    User selectByUsername(String username);
}