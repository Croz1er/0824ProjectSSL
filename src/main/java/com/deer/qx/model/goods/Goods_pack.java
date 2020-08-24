package com.deer.qx.model.goods;

import java.io.Serializable;
import java.util.Date;

/*
* 套餐
* */
public class Goods_pack implements Serializable {

    private Integer id;
    //套餐名称
    private String goodsPackName;
    //套餐编码
    private String goodsPackCode;
    //套餐类型ID
    private Integer typeId;
    //套餐类型NAME
    private String typeName;
    //套餐总价（系统生成，保存时根据相关商品的优惠价*数量计算生成）
    private Double totalPrice;
    //状态（1. 上架   2. 下架）
    private Integer state;
    //备注说明
    private String note;
    //库存数量
    private Integer num;
    //创建人
    private String createdBy;
    //创建时间
    private Date createTime;
    //最后更新时间
    private Date lastUpdateTime;

}
