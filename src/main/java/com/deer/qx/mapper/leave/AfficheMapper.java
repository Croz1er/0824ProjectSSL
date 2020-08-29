package com.deer.qx.mapper.leave;

import com.deer.qx.model.info.Affiche;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AfficheMapper {

    @Select(value = "select * from affiche")
    List<Affiche> findAll()throws Exception;

    @Insert(value = "insert into affiche (title,content,publisher,publishTime,startTime,endTime) values (#{title},#{content},#{publisher},#{publishTime},#{startTime},#{endTime})")
    int insertAffiche(Affiche affiche)throws Exception;

    @Delete(value = "delete from affiche where id =#{id}")
    int deleteById(int id)throws Exception;

    @Update(value = "update affiche set title =#{title},content=#{content},publishTime=#{publishTime} where id =#{id}")
    int updateAffiche(Affiche affiche)throws Exception;
}
