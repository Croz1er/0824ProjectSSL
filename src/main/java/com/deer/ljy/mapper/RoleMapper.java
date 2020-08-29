package com.deer.ljy.mapper;

import com.deer.ljy.pojo.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RoleMapper {

    /**
     * 查询所有角色
     * @return
     */
    @Select("select * from au_role")
    List<Role> selectAllRole();

    /**
     * 通过id查询角色
     * @param id
     * @return
     */
    @Select("select roleName from au_role where id = #{id}")
    Role selectRolebyId(Integer id);

    /**
     * 通过id删除角色
     * @param id
     * @return
     */
    @Delete("delete from au_role where id = #{id}")
    int delRoleById(Integer id);

    /**
     * 修改角色信息
     * @param role
     * @return
     */
    @Update("update au_role set roleCode=#{roleCode},roleName=#{roleName},isStart=#{isStart} where id = #{id}")
    int updateRoleById(Role role);

    /**
     * 添加角色信息
     * @param role
     * @return
     */
    @Insert("insert into au_role(roleCode,roleName,createDate,isStart,createBy) values(#{roleCode},#{roleName},#{createDate},#{isStart},#{createBy})")
    int insertRole(Role role);
}
