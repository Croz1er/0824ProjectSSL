package com.deer.qx.service.cart;

import com.deer.qx.model.goods.Goods_info;
import com.deer.qx.model.shop.Shopcart;

import java.util.List;

public interface CartService {

    List<Shopcart> selectAll();

    int insertCar(Shopcart shopcart);
}
