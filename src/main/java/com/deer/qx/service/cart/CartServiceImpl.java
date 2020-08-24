package com.deer.qx.service.cart;

import com.deer.qx.dao.cart.CartDao;
import com.deer.qx.model.shop.Shopcart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService{

    @Autowired
    private CartDao cartDao;

    @Override
    public List<Shopcart> selectAll() {
        return null;
    }
}
