package com.deer.ljy.service;

import com.deer.ljy.pojo.Func;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface FunctionService {

    List<Func> selectAllFunc(Integer roleId);

    int insertFunc(Func func);

    int deleteFunc(Integer id);

    int updateFunc(Func func);

    int deleteFuncByRoleId(Integer roleId);
    Integer insertFuncByRoleId(Integer roleId, Integer funcId, String creationTime, String createdBy) throws Exception;

}
