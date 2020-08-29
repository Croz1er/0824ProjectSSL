package com.deer.qx.controller.leave;

import com.deer.ljy.pojo.User;
import com.deer.ljy.pojo.base.BaseResult;
import com.deer.qx.model.leave.Leave_message;
import com.deer.qx.service.leave.LeaveMessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/leaveMessage")
public class LeaveMessageController {
    @Autowired
    private LeaveMessageService leaveMessageService;

    @RequestMapping("/findAll.do")
    public BaseResult findAll()throws Exception{
        BaseResult result=new BaseResult();
        List<Leave_message> list = leaveMessageService.findAll();
        if (!list.isEmpty()){
            result.setData(list);
            result.setCode(0);
        }else {
            result.setCode(1);
        }
        return result;
    }

    @RequestMapping("/findByName.do")
    public BaseResult findByUsername(HttpSession session)throws Exception{
        BaseResult result=new BaseResult();
        User sessionUser =(User) session.getAttribute("sessionUser");
        List<Leave_message> list = leaveMessageService.findByUsername(sessionUser.getUsername());
        if (!list.isEmpty()){
            result.setData(list);
            result.setCode(0);
        }else {
            result.setCode(1);
        }
        return result;
    }

    @RequestMapping("/save.do")
    public BaseResult insertLeave_message(HttpSession session,Leave_message leaveMessage)throws Exception{
        BaseResult result=new BaseResult();
        User sessionUser =(User) session.getAttribute("sessionUser");
        leaveMessage.setCreatedBy(sessionUser.getUsername());
        leaveMessage.setCreateTime(new Date());
        leaveMessage.setState(0);
        int i = leaveMessageService.insertLeave_message(leaveMessage);
        if (i>0){
            result.setCode(0);
        }else {
            result.setCode(1);
        }
        return result;
    }

    @RequestMapping("/removeById.do")
    public BaseResult delete(int id)throws Exception{
        BaseResult result=new BaseResult();
       leaveMessageService.delete(id);
       result.setCode(0);
        return result;
    }


}
