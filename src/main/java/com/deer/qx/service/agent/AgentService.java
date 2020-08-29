package com.deer.qx.service.agent;

import com.deer.ljy.pojo.User;
import com.deer.qx.model.agent.Agent;
import com.deer.qx.model.goods.Goods_info;

import java.util.List;

public interface AgentService {

    List<User> selectById(User user);

    int del(User user);

    int update(User user);
    List<Agent> select();


}
