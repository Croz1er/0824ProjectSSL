package com.deer.ljy.service;

import com.deer.ljy.mapper.FunctionMapper;
import com.deer.ljy.pojo.Func;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Transactional(readOnly = true)
@Service
public class FunctionServiceImpl implements FunctionService {

    @Resource
    private FunctionMapper functionMapper;

    @Override
    public List<Func> selectAllFunc(Integer roleId) {
        return functionMapper.selectAllFunc(roleId);
    }

    @Transactional
    @Override
    public int insertFunc(Func func) {
        return functionMapper.insertFunc(func);
    }

    @Transactional
    @Override
    public int deleteFunc(Integer id) {
        return functionMapper.deleteFunc(id);
    }

    @Transactional
    @Override
    public int updateFunc(Func func) {
        return functionMapper.updateFunc(func);
    }

    @Transactional
    @Override
    public int deleteFuncByRoleId(Integer roleId) {
        return functionMapper.deleteFuncByRoleId(roleId);
    }

    @Transactional
    @Override
    public Integer insertFuncByRoleId(Integer roleId, Integer funcId, String creationTime, String createdBy) throws Exception {
        return functionMapper.insertFuncByRoleId(roleId, funcId, creationTime, createdBy);
    }
}
