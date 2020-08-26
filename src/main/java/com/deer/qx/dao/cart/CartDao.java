package com.deer.qx.dao.cart;

import com.deer.qx.model.shop.Shopcart;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CartDao {

    @Select(value = "select * from shopcart where userId = #{userId}")
    List<Shopcart> selectAll();
}
