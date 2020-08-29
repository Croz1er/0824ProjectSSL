package com.deer.qx.mapper.vip;

import com.deer.ljy.pojo.User;
import com.deer.qx.model.account.Account_detail;
import com.deer.qx.model.account.User_account;
import com.deer.qx.model.order.Order_goods;
import com.deer.qx.model.order.Order_info;
import com.deer.qx.model.order.Order_user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface VipMapper {

    //购买会员
    @Update(value = "update au_user set username =#{username} , userAddress =#{userAddress} , postCode =#{postCode} , roleId =#{roleId} , roleName =#{roleName} , lastUpdateTime=#{lastUpdateTime} where id = #{id}")
    int updateVip(User user);
    //修改余额
    @Update(value = "update user_account set balance= (balance - #{balance}) where userId =#{userId}")
    int  updateBalance(User_account user_account);

    @Insert(value = "insert into order_info (orderCode,orderPrice,createTime,createBy,lastUpdateTime,status,userId) values (#{orderCode},#{orderPrice},#{createTime},#{createBy},#{lastUpdateTime},#{status},#{userId})")
    int insertOrdersInfo(Order_info order_info);

    @Insert(value = "insert into order_user (rolename,rolePrice,roleId,createBy,createDateTime,orderinfoId) values(#{rolename},#{rolePrice},#{roleId},#{createBy},#{createDateTime},#{orderinfoId})")
    int insertOrdersUser(Order_user order_user);

    //返回id
    @Select(value = "select max(id) from order_info")
    int selectGetId();

    @Insert(value = "insert into account_detail (accountId,accountDate,moneyOut,type,otherAcountId,moneyIn,credit) values (#{accountId},#{accountDate},#{moneyOut},1,#{otherAcountId},0,#{credit})")
    int insertAccount_detail(Account_detail account_detail);

    //查询余额
    @Select(value = "select * from user_account where userId=#{userId}")
    User_account selectByBalance(int userId);

}
