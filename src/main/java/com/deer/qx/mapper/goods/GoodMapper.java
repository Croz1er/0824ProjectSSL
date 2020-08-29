package com.deer.qx.mapper.goods;

import com.deer.qx.model.goods.Cart_goods;
import com.deer.qx.model.goods.Goods_info;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.elasticsearch.common.recycler.Recycler;

import java.util.List;

public interface GoodMapper {

    //查看商品信息
//    @Select(value = "select * from goods_info")
    @Select({"<script>",
            "select * from goods_info",
            "<where>",
            "<if test=\'goodsName != null and goodsName != \"\" and goodsName!=\"null\"\'>",
            "and goodsName like concat('%',#{goodsName},'%')",
            "</if></where>",
            "</script>"})
    List<Goods_info> selectAll(Goods_info goods_info);

    //删除商品
    @Delete(value = "delete from goods_info where id=#{id}")
    int delById(int id);

    //更新商品
    @Update(value = "update goods_info set goodsSN=#{goodsSN},goodsName=#{goodsName},goodsFormat=#{goodsFormat},marketPrice=#{marketPrice},realPrice=#{realPrice},note=#{note},num=#{num},state=#{state},lastUpdateTime=#{lastUpdateTime} where id =#{id}")
    int updateGoods(Goods_info goods_info);

    //添加商品
    @Insert(value = "insert into goods_info (goodsSN,goodsName,goodsFormat,marketPrice,realPrice,state,note,num,unit,createTime,lastUpdateTime,createdBy) values" +
            "(#{goodsSN},#{goodsName},#{goodsFormat},#{marketPrice},#{realPrice},#{state},#{note},#{num},#{unit},#{createTime},#{lastUpdateTime},#{createdBy})")
    int insertGoods(Goods_info goods_info);

    //添加购物车
    @Insert(value = "insert into cart_goods (goodsId,goodsName,goodsPrice,goodsNum,cartId,flag,createBy,createTime,lastUpdateTime,money) values (#{goodsId},#{goodsName},#{goodsPrice},#{goodsNum},1,1,#{createBy},#{createTime},#{lastUpdateTime},#{goodsPrice})")
    int insertCart(Cart_goods cart_goods);

    @Update(value = "update cart_goods set goodsNum=goodsNum+#{goodsNum},lastUpdateTime = #{lastUpdateTime},money=money+#{goodsPrice} where goodsId= #{goodsId}")
    int updateCart(Cart_goods cart_goods);

    @Update(value = "update goods_info set num=num-#{goodsNum},lastUpdateTime = #{lastUpdateTime} where id= #{goodsId}")
    int updateCartGoods(Cart_goods cart_goods);

    @Select(value = "select * from cart_goods where goodsId = #{goodsId}")
    Cart_goods selectCar(Cart_goods cart_goods);

    //查库存
    @Select(value = "select * from goods_info where id =#{id}")
    Goods_info selectFindNum(Goods_info goods_info);

    //更改状态
    @Update(value = "update goods_info set state=2 where id =#{id}")
    int updateState(Goods_info goods_info);


    //模糊查询

    @Select({"<script>",
            "select * from goods_info",
            "<where>",
            "<if test=\'goodsName != null and goodsName != \"\" and goodsName!=\"null\"\'>",
            "and goodsName like concat('%',#{goodsName},'%')",
            "</if></where>",
            "</script>"})
    List<Goods_info> findVague(Goods_info goods_info);






}
