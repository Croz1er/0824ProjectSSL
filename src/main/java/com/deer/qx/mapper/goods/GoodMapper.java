package com.deer.qx.mapper.goods;

import com.deer.qx.model.goods.Goods_info;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodMapper {

    @Select(value = "select * from goods_info")
    List<Goods_info> selectAll();




}
