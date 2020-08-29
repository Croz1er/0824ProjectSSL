package com.deer.qx.service.cart;

import com.deer.qx.model.goods.Cart_goods;
import com.deer.qx.model.goods.Goods_info;
import com.deer.qx.model.shop.Shopcart;

import java.util.List;

public interface CartService {

    List<Cart_goods> selectAll(Cart_goods cart_goods, int page, int limit);

    int insertCar(Shopcart shopcart);

    int deleteCart(Cart_goods cart_goods);
}
