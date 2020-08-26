package com.deer.ljy.controller;


import com.deer.ljy.pojo.User;


import com.deer.ljy.pojo.base.BaseResult;

import com.deer.ljy.service.UserService;

import org.apache.shiro.SecurityUtils;

import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.session.Session;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    //跳转首页
    @RequiresUser
    @RequestMapping("/session.do")
    public BaseResult<User> login(HttpServletRequest request) {
        BaseResult<User> result = new BaseResult<>();
        String username = request.getRemoteUser();
        User userByUsername = userService.findUserByUsername(username);
        if (userByUsername != null) {
            result.setCode(0);
            result.setData(userByUsername);
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("sessionUser", userByUsername);
        } else {
            result.setCode(1);
        }
        return result;
    }

    //获取session
    @RequestMapping("/sessionUser.do")
    public BaseResult<User> sessionUser(){
        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute("sessionUser");
        BaseResult<User> result = new BaseResult<>();
        result.setData(user);
        return result;
    }


}
