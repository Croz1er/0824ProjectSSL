package com.deer.qx.service.cart;

import com.deer.qx.model.shop.Shopcart;

import java.util.List;

public interface CartService {

    List<Shopcart> selectAll();
}
