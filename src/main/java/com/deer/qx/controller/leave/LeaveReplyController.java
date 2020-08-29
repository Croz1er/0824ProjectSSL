package com.deer.qx.controller.leave;


import com.deer.ljy.pojo.User;
import com.deer.ljy.pojo.base.BaseResult;
import com.deer.qx.model.leave.Leave_reply;
import com.deer.qx.service.leave.LeaveMessageService;
import com.deer.qx.service.leave.LeaveReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/leaveReply")
public class LeaveReplyController {

    @Autowired
    private LeaveReplyService leaveReplyService;
    @Autowired
    private LeaveMessageService leaveMessageService;

    @RequestMapping("/saveMessage.do")
    public BaseResult save(Leave_reply leaveReply, HttpSession session)throws Exception{
        System.out.println(leaveReply.getMessageId());
        System.out.println(leaveReply.getReplyContent());
        
        BaseResult result= new BaseResult();
        User sessionUser =(User) session.getAttribute("sessionUser");
        leaveReply.setCreatedBy(sessionUser.getUsername());
        leaveReply.setCreateTime(new Date());
        int i = leaveReplyService.insertLeave_reply(leaveReply);
        int modify = leaveMessageService.updateById(leaveReply.getMessageId());
        if (i>0 && modify>0){
            result.setCode(0);
        }else {
            result.setCode(1);
        }
        return  result;
    }
}
