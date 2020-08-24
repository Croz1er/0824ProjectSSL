package com.deer.ljy.controller;

import com.deer.ljy.pojo.User;


import com.deer.ljy.pojo.base.BaseResult;
import com.deer.ljy.service.UserService;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    //跳转首页
    @RequiresUser
    @RequestMapping("/session.do")
    public BaseResult login(HttpServletRequest request){
        BaseResult<User> result = new BaseResult<>();
        String username = request.getRemoteUser();
        User userByUsername = userService.findUserByUsername(username);
        if (userByUsername!=null){
            result.setCode(0);
            result.setData(userByUsername);
        }else {
            result.setCode(1);
        }
        return result;
    }

}
