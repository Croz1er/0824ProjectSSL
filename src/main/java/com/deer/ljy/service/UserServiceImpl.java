package com.deer.ljy.service;

import com.deer.ljy.pojo.User;
import com.deer.ljy.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findUserByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Transactional
    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> selectAll(User user,int page,int limit) {
        PageHelper.startPage(page,limit);
        return userMapper.selectAll(user);
    }

    @Transactional
    @Override
    public int update1(String new_password, Integer id) {
        return userMapper.update1(new_password, id);
    }

    @Transactional
    @Override
    public int update2(String new_password, Integer id) {
        return userMapper.update2(new_password, id);
    }

    @Transactional
    @Override
    public int updatePWD(String new_password, Integer id, Integer globe) {
        int count=0;
        if (globe==1){
            count = update1(new_password, id);
        }else {
            count = update2(new_password, id);
        }
        return count;
    }
}
