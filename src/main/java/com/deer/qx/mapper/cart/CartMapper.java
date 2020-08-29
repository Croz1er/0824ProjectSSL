package com.deer.qx.mapper.cart;

import com.deer.qx.model.account.Account_detail;
import com.deer.qx.model.goods.Cart_goods;
import com.deer.qx.model.order.Order_goods;
import com.deer.qx.model.shop.Shopcart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CartMapper {

    //购物车信息
    @Select(value = "select * from cart_goods where createBy = #{createBy}")
    List<Cart_goods> selectAll(Cart_goods cart_goods);

    //删除购物车
    @Delete(value = "delete from cart_goods where id = #{id}")
    int deleteCart(Cart_goods cart_goods);



}
