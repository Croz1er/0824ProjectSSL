package com.deer.ljy.service;

import com.deer.ljy.pojo.User;

import java.util.List;

public interface UserService {

    User findUserByUsername(String username);

    int insertUser(User user);

    List<User> findAllUser();
    List<User> findAllUser1();

    User findUserById(Integer id);

    List<User> selectAll(User user,Integer level,int page,int limit);

    int update1(String new_password,Integer id);

    int update2(String new_password,Integer id);

    int lockUser(int isStart, Integer id);

    int updatePWD(String new_password,Integer id,Integer globe);

    int deleteUser(Integer id);

    int updateUSer(User user);


}
