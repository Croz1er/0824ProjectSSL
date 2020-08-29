package com.deer.ljy.mapper;

import com.deer.ljy.pojo.Dictionary;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DictionaryMapper {

    /**
     * 查找所有的数据字典
     * @return
     */
    @Select("select * from data_dictionary")
    List<Dictionary> selectAllDict();

    /**
     * 通过类型查找对应的字典
     * @param typeName
     * @return
     */
    @Select("select * from data_dictionary where typeName = #{typeName}")
    List<Dictionary> selectDictByType(String typeName);

    /**
     * 通过类型查找对应的字典
     * @param id
     * @return
     */
    @Select("select * from data_dictionary where id = #{id}")
    Dictionary selectDictById(Integer id);
    /**
     * 修改某个字典
     * @param dictionary
     * @return
     */
    @Update("update data_dictionary set typeCode =#{typeCode}, typeName = #{typeName}, valueId = #{valueId}, valueName = #{valueName}  where id = #{id}")
    int updateDictionary(Dictionary dictionary);

    /**
     * 删除某个字典通过id
     * @param id
     * @return
     */
    @Delete("delete from data_dictionary where id = #{id}")
    int deleteDictionary(int id);

    /**
     * 添加一个字典
     * @param dictionary
     * @return
     */
    @Insert("insert into data_dictionary(typeCode,typeName,valueId,valueName) values(#{typeCode},#{typeName},#{valueId},#{valueName})")
    int insertDictionary(Dictionary dictionary);
}
