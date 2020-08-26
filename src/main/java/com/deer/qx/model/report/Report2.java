package com.deer.qx.model.report;

import java.io.Serializable;
import java.util.Date;

public class Report2 implements Serializable {

    private Integer id;
    //销售额度
    private  Double totalMoney;
    private Date createTime;
    //0会员销售,1商品销售
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
