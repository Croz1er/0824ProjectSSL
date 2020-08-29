package com.deer.qx.service.agent;

import com.deer.ljy.pojo.User;
import com.deer.qx.mapper.agent.AgetnMapper;
import com.deer.qx.model.agent.Agent;
import com.deer.qx.model.goods.Goods_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgetnMapper agetnMapper;

    @Override
    public List<User> selectById(User user) {
        return agetnMapper.selectById(user);
    }

    @Override
    @Transactional
    public int del(User user) {
        return agetnMapper.del(user);
    }

    @Override
    @Transactional
    public int update(User user) {
        return agetnMapper.update(user);
    }


    @Override
    public List<Agent> select() {
        return agetnMapper.select();
    }
}
