package com.deer.qx.service.leave;

import com.deer.qx.model.leave.Leave_message;


import java.util.List;

public interface LeaveMessageService {

    List<Leave_message> findAll()throws Exception;

    List<Leave_message> findByUsername(String username)throws Exception;

    int insertLeave_message(Leave_message leaveMessage)throws Exception;

    int delete(int id)throws Exception;

    int updateById(int id)throws Exception;
}
