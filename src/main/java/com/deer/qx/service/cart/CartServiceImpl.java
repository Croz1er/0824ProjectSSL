package com.deer.qx.service.cart;

import com.deer.qx.mapper.cart.CartMapper;
import com.deer.qx.model.goods.Goods_info;
import com.deer.qx.model.shop.Shopcart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService{

    @Autowired
    private CartMapper cartDao;

    @Override
    public List<Shopcart> selectAll() {
        return null;
    }

    @Override
    @Transactional
    public int insertCar(Shopcart shopcart) {
        return cartDao.insertCar(shopcart);
    }
}
