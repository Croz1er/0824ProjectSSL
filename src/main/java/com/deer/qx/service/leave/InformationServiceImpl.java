package com.deer.qx.service.leave;

import com.deer.qx.mapper.leave.InformationMapper;
import com.deer.qx.model.info.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
public class InformationServiceImpl implements  InformationService {

    @Autowired
    private InformationMapper informationMapper;
    @Override
    public List<Information> findAll() throws Exception {
        return informationMapper.findAll();
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public int insertInformation(Information information) throws Exception {
        return informationMapper.insertInformation(information);
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public int deleteById(int id) throws Exception {
       return informationMapper.deleteById(id);
    }
}
