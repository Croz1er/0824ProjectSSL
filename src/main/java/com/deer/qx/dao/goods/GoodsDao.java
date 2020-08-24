package com.deer.qx.dao.goods;

import com.deer.qx.model.goods.Goods_info;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsDao {

    @Select(value = "select * from goods_info")
    List<Goods_info> selectAll();




}
