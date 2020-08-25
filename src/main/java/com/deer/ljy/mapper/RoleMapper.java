package com.deer.ljy.mapper;

import com.deer.ljy.pojo.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    @Select("select * from au_role")
    List<Role> selectAllRole();

    @Select("select roleName from au_role where id = #{id}")
    Role selectRolebyId(Integer id);

}
