package com.deer.qx.controller.agent;

import com.deer.ljy.pojo.User;
import com.deer.ljy.pojo.base.BaseResult;
import com.deer.qx.model.agent.Agent;
import com.deer.qx.service.agent.AgentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @RequiresPermissions("/agent/select.do")
    @RequestMapping("/findAll.do")
    public BaseResult findAll(User user){
        Session session = SecurityUtils.getSubject().getSession();
        User sessionUser =(User) session.getAttribute("sessionUser");

        List<User> users = agentService.selectById(sessionUser);
        BaseResult result = new BaseResult();
        if(!users.isEmpty()){
            result.setCode(0);
            result.setData(users);
            return result;
        }else {
            result.setCode(1);
            return result;
        }
    }

    @RequestMapping("/del.do")
    public BaseResult del(User user){
        int del = agentService.del(user);
        BaseResult result = new BaseResult();
        if(del>0){
            result.setCode(0);
            return result;
        }else {
            result.setCode(1);
            return result;
        }
    }


    @RequestMapping("/update.do")
    public BaseResult update(User user){
        int update = agentService.update(user);
        BaseResult result = new BaseResult();
        if(update>0){
            result.setCode(0);
            return result;
        }else {
            result.setCode(1);
            return result;
        }
    }


    @RequestMapping("/chart.do")
    public  BaseResult chart(){
        List<Agent> select = agentService.select();
        BaseResult result = new BaseResult();
        if(!select.isEmpty()){
            result.setCode(0);
            result.setData(select);
            return result;
        }
        else {
            result.setCode(1);
            return result;
        }
    }


    
}
