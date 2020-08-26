package com.deer.ljy.service;

import com.deer.ljy.pojo.User;

import java.util.List;

public interface UserService {

    User findUserByUsername(String username);

    int insertUser(User user);

    List<User> findAllUser();

    User findUserById(Integer id);

    List<User> selectAll(User user,int page,int limit);

    int update1(String new_password,Integer id);

    int update2(String new_password,Integer id);

    int updatePWD(String new_password,Integer id,Integer globe);

}
