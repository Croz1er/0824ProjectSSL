package com.deer.ljy.service;

import com.deer.ljy.pojo.User;
import com.deer.ljy.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findUserByUsername(String username) {
        return userMapper.selectByUsername(username);
    }
}
