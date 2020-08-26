package com.deer.qx.mapper.cart;

import com.deer.qx.model.goods.Goods_info;
import com.deer.qx.model.shop.Shopcart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CartMapper {

    //商品信息
    @Select(value = "select * from shopcart where userId = #{userId}")
    List<Shopcart> selectAll();

    //添加购物车
    @Insert(value = "insert into shopcart (userId,totalPrice,createby,lastUpdateTime,createTime) values (#{userId},#{totalPrice},#{createby},#{lastUpdateTime},#{createTime})")
    int insertCar(Shopcart shopcart);
}
