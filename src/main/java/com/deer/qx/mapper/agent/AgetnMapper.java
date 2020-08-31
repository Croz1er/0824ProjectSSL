package com.deer.qx.mapper.agent;

import com.deer.ljy.pojo.User;
import com.deer.qx.model.agent.Agent;
import org.apache.ibatis.annotations.Insert;
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

    @Select(value = "SELECT agent.reward,au_user.username,agent.num FROM agent LEFT JOIN au_user ON agent.userid = " +
            "au_user.id")
    List<Agent> select();

    @Insert("insert into agent(userId,reward) values(#{userId},50)")
    int insertAgent(Integer userId);

    @Select("SELECT MAX(id) FROM au_user")
    int selectMaxId();

}
