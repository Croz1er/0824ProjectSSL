package com.deer.qx.mapper.agent;

import com.deer.ljy.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AgetnMapper {

    @Select(value = "select * from au_user where referId= #{id}")
    List<User> selectById(User user);

    @Update(value = "update  au_user set referId =0 , referCode ='' where id =#{id}")
    int del(User user);

    @Update(value = "update  au_user set isStart =1 where id =#{id}")
    int update(User user);



}
