package com.deer.qx.service.goods;

import com.deer.qx.model.goods.Cart_goods;
import com.deer.qx.model.goods.Goods_info;

import java.util.List;

public interface GoodsService {

    List<Goods_info> selectAll(Goods_info goods_info, int page, int limit);

    int delById(String isid);

    int updateGoods(Goods_info goods_info);

    int insertGoods(Goods_info goods_info);

    int insertCart(Cart_goods cart_goods);

    int updateCart(Cart_goods cart_goods);

    Cart_goods selectCar(Cart_goods cart_goods);

    int updateCartGoods(Cart_goods cart_goods);

    Goods_info selectFindNum(Goods_info goods_info);

    int updateState(Goods_info goods_info);

    List<Goods_info> findVague(Goods_info goods_info);

}
