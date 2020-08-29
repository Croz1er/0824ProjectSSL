package com.deer.qx.mapper.leave;

import com.deer.qx.model.leave.Leave_message;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LeaveMessageMapper {

    @Select(value = "select * from leave_message")
    List<Leave_message> findAll()throws Exception;

    @Select(value = "select * from leave_message where createdBy = #{username}")
    List<Leave_message> findByUsername(String username)throws Exception;

    @Insert(value = "insert into leave_message (createdBy,messageCode,messageTitle,messageContent,state,createTime) values (#{createdBy},#{messageCode},#{messageTitle},#{messageContent},#{state},#{createTime})")
    int insertLeave_message(Leave_message leaveMessage)throws Exception;

    @Delete(value = "delete from leave_message where id =#{id}")
    int delete(int id)throws Exception;

    @Update(value = "update leave_message set state=1 where id =#{id}")
    int updateById(int id)throws Exception;

}
