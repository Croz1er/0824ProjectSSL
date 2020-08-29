package com.deer.qx.model.goods;


import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
/*
* 商品
* */
public class Goods_info implements Serializable {

    private Integer id;
    //商品编码
    private String GoodsSN;
    //商品名称
    private String goodsName;
    //商品规格
    private String goodsFormat;
    //市场价
    private Double marketPrice;
    //优惠价
    private Double realPrice;
    //状态（1.上架   2.下架）
    private Integer state;
    //商品说明
    private String note;
    //库存数量
    private Integer num;
    //单位
    private String unit;
    //创建时间
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date createTime;
    //最后更新时间
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date lastUpdateTime;
    //创建人
    private String createdBy;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsSN() {
        return GoodsSN;
    }

    public void setGoodsSN(String goodsSN) {
        GoodsSN = goodsSN;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsFormat() {
        return goodsFormat;
    }

    public void setGoodsFormat(String goodsFormat) {
        this.goodsFormat = goodsFormat;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Double realPrice) {
        this.realPrice = realPrice;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
