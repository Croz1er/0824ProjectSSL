package com.deer.qx.service.goods;

import com.deer.qx.mapper.goods.GoodMapper;
import com.deer.qx.model.goods.Cart_goods;
import com.deer.qx.model.goods.Goods_info;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodMapper goodMapper;

    @Override
    public List<Goods_info> selectAll(Goods_info goods_info,int page,int limit) {
        PageHelper.startPage(page,limit);
        return goodMapper.selectAll(goods_info );
    }

    @Override
    @Transactional
    public int delById(String isid) {
        if(isid!=null&& !isid.equals("")){
            String [] ids = isid.split(",");
            for (String sid:ids) {
                if (sid != null && !sid.equals("")) {
                    int id = Integer.parseInt(sid);
                    int i = goodMapper.delById(id);
                }
            }
            return 1;
        }
        return 0;
    }

    @Override
    @Transactional
    public int updateGoods(Goods_info goods_info) {
        return goodMapper.updateGoods(goods_info);
    }

    @Override
    @Transactional
    public int insertGoods(Goods_info goods_info) {
        return goodMapper.insertGoods(goods_info);
    }

    @Override
    @Transactional
    public int insertCart(Cart_goods cart_goods) {
        return goodMapper.insertCart(cart_goods);
    }

    @Override
    @Transactional
    public int updateCart(Cart_goods cart_goods) {
        return goodMapper.updateCart(cart_goods);
    }

    @Override
    public Cart_goods selectCar(Cart_goods cart_goods) {
        return goodMapper.selectCar(cart_goods);
    }

    @Override
    @Transactional
    public int updateCartGoods(Cart_goods cart_goods) {
        return goodMapper.updateCartGoods(cart_goods);
    }

    @Override
    public Goods_info selectFindNum(Goods_info goods_info) {
        return goodMapper.selectFindNum(goods_info);
    }

    @Override
    @Transactional
    public int updateState(Goods_info goods_info) {
        return goodMapper.updateState(goods_info);
    }

    @Override
    public List<Goods_info> findVague(Goods_info goods_info) {
        return goodMapper.findVague(goods_info);
    }
}
