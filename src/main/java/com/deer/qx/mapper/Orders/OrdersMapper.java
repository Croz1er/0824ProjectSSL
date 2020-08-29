package com.deer.qx.mapper.Orders;

import com.deer.qx.model.account.Account_detail;
import com.deer.qx.model.account.User_account;
import com.deer.qx.model.goods.Cart_goods;
import com.deer.qx.model.order.Order_goods;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface OrdersMapper {

    //添加订单
    @Insert(value = "insert into order_goods (goodsId,goodsName,goodsPrice,goodsNum,createBy,createTime,lastUpdateTime,orderInfoId) values (#{goodsId},#{goodsName},#{goodsPrice},#{goodsNum},#{createBy},#{createTime},#{lastUpdateTime},#{orderInfoId})")
    int insertOrdersGoods(Order_goods order_goods);

    @Insert(value = "insert into order_info (orderCode,orderPrice,createTime,createBy,lastUpdateTime,status,userId) values (#{orderInfoId},#{money},#{createTime},#{createBy},#{lastUpdateTime},#{status},#{userId})")
    int insertOrdersInfo(Order_goods order_goods);

    @Delete(value = "delete from cart_goods where id = #{cid}")
    int deleteCart(Order_goods order_goods);

    //结算
    @Update(value = "update user_account set balance= (balance - #{balance}) , lastUpdateTime =#{lastUpdateTime} where id =#{id}")
    int  updateOut(User_account user_account);

    //订单明细

    @Select(value = "select * from order_goods where createBy = #{createBy}")
    List<Order_goods> selectAll(Order_goods order_goods);

    //删除订单
    @Delete(value = "delete from order_goods where id = #{id}")
    int deleteOrders(int id);


}
