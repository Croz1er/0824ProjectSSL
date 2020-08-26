package com.deer.ljy.mapper;

import com.deer.ljy.pojo.User;
import com.deer.ljy.provider.UserProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select("select * from au_user where username = #{username}")
    User selectByUsername(String username);

    @Select("select username from au_user where id = #{id}")
    User selectById(Integer id);

    @Insert("insert into au_user" +
            "(username,password,password2,realName,cardTypeName,idCard,country,mobile," +
            "email,userAddress,postCode,referId,referCode,roleId,roleName," +
            "createTime,isStart,lastUpdateTime,lastLoginTime,bankName,accountHolder,bankAccount)" +
            "values" +
            "(#{username},#{password},#{password2},#{realName},#{cardTypeName},#{idCard},#{country},#{mobile}," +
            "#{email},#{userAddress},#{postCode},#{referId},#{referCode},#{roleId},#{roleName}," +
            "#{createTime},#{isStart},#{lastUpdateTime},#{lastLoginTime},#{bankName},#{accountHolder},#{bankAccount})")
    int insertUser(User user);

    @Select("select * from au_user where roleId != 2")
    List<User> selectAllUser();

    @SelectProvider(type = UserProvider.class,method = "selectAll")
    List<User> selectAll(final User user);

    @Update("update au_user set password=#{new_password} where id=#{id}")
    int update1(String new_password,Integer id);
    @Update("update au_user set password2=#{new_password} where id=#{id}")
    int update2(String new_password,Integer id);
}