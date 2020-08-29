package com.deer.qx.mapper.leave;

import com.deer.qx.model.leave.Leave_reply;
import org.apache.ibatis.annotations.Insert;


public interface LeaveReplyMapper {

    @Insert(value = "insert into leave_reply (createdBy,messageId,replyContent,createTime) values (#{createdBy},#{messageId},#{replyContent},#{createTime})")
    int insertLeave_reply(Leave_reply leaveReply)throws Exception;
}
