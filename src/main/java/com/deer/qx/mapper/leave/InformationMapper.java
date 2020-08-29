package com.deer.qx.mapper.leave;

import com.deer.qx.model.info.Information;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InformationMapper {

    @Select(value = "select * from information")
    List<Information> findAll() throws  Exception;

    @Insert(value = "insert into information (title,content,state,publisher,publishTime) values (#{title},#{content},#{state},#{publisher},#{publishTime})")
    int insertInformation(Information information) throws Exception;

    @Insert(value = "insert into information (title,content,state,publisher,publishTime,typeId,typeName,fileName,filePath,fileSize,uploadTime) values " +
            "(#{title},#{content},#{state},#{publisher},#{publishTime},#{typeId},#{typeName},#{fileName},#{filePath},#{fileSize},#{uploadTime})")
    int insertInformationAndFile(Information information) throws Exception;

    @Delete(value = "delete from information where id =#{id}")
    int  deleteById(int id) throws Exception;
}
