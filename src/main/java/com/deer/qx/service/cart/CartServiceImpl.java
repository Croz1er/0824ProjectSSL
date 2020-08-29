package com.deer.qx.service.cart;

import com.deer.qx.mapper.cart.CartMapper;
import com.deer.qx.model.goods.Cart_goods;
import com.deer.qx.model.goods.Goods_info;
import com.deer.qx.model.shop.Shopcart;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService{

    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<Cart_goods> selectAll(Cart_goods cart_goods,int page,int limit) {
        PageHelper.startPage(page,limit);
        return cartMapper.selectAll(cart_goods);
    }

    @Override
    @Transactional
    public int insertCar(Shopcart shopcart) {
//        return cartMapper.insertCar(shopcart);
        return 0;
    }

    @Override
    @Transactional
    public int deleteCart(Cart_goods cart_goods) {
        return cartMapper.deleteCart(cart_goods);
    }
}
