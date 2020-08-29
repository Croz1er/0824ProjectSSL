package com.deer.qx.service.leave;

import com.deer.qx.mapper.leave.LeaveReplyMapper;
import com.deer.qx.model.leave.Leave_reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class LeaveReplyServiceImpl implements LeaveReplyService {

    @Autowired
    private LeaveReplyMapper leaveReplyMapper;
    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public int insertLeave_reply(Leave_reply leaveReply) throws Exception {
        return leaveReplyMapper.insertLeave_reply(leaveReply);
    }
}
