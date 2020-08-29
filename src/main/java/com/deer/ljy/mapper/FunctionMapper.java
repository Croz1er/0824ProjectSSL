package com.deer.ljy.mapper;

import com.deer.ljy.pojo.Func;
import com.deer.ljy.provider.FuncProvider;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface FunctionMapper {

    @SelectProvider(type = FuncProvider.class,method = "selectAllFuncByRoleId")
    List<Func> selectAllFunc(Integer roleId);

    @Insert("insert into au_function" +
            "(funcCode,funcName,funcUrl,parentId,creationTime)" +
            " values(#{funcCode},#{funcName},#{funcUrl},#{parentId},#{creationTime})")
    int insertFunc(Func func);

    @Delete("delete from au_function where id = #{id}")
    int deleteFunc(Integer id);

    @Delete("delete from au_authority where roleId = #{roleId}")
    int deleteFuncByRoleId(Integer roleId);

    @Update("update au_function set funcCode = #{funcCode},funcName=#{funcName},funcUrl=#{funcUrl},parentId=#{parentId} where id = #{id} ")
    int updateFunc(Func func);

    @Insert("insert into au_authority (roleId,functionId,creationTime,createdBy)" +
            "values(#{roleId},#{funcId},#{creationTime},#{createdBy})")
    Integer insertFuncByRoleId(
            @Param("roleId") Integer roleId,
            @Param("funcId")  Integer funcId,
            @Param("creationTime") String creationTime,
            @Param("createdBy")String createdBy) throws Exception;
}
