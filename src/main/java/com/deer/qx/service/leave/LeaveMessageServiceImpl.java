package com.deer.qx.service.leave;

import com.deer.qx.mapper.leave.LeaveMessageMapper;
import com.deer.qx.model.leave.Leave_message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
public class LeaveMessageServiceImpl implements LeaveMessageService {

    @Autowired
    private LeaveMessageMapper leaveMessageMapper;
    @Override
    public List<Leave_message> findAll() throws Exception {
        return leaveMessageMapper.findAll();
    }

    @Override
    public List<Leave_message> findByUsername(String username) throws Exception {
        Leave_message leaveMessage= new Leave_message();
       leaveMessage.setCreatedBy(username);
        Example<Leave_message> of = Example.of(leaveMessage);
        return leaveMessageMapper.findAll();
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public int insertLeave_message(Leave_message leaveMessage) throws Exception {
        return leaveMessageMapper.insertLeave_message(leaveMessage);
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public int delete(int id) throws Exception {
       return leaveMessageMapper.delete(id);
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public int updateById(int id) throws Exception {
        return leaveMessageMapper.updateById(id);
    }
}
