package com.deer.qx.model.order;

import java.io.Serializable;
import java.util.Date;

public class Order_user implements Serializable {

    private Integer id;
    //关联订单表
    private Integer orderinfoId;
    //会员类型
    private String rolename;
    //会员价格
    private Double rolePrice;
    //关联角色表
    private Integer roleId;
    private String createBy;
    private Date createDateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderinfoId() {
        return orderinfoId;
    }

    public void setOrderinfoId(Integer orderinfoId) {
        this.orderinfoId = orderinfoId;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Double getRolePrice() {
        return rolePrice;
    }

    public void setRolePrice(Double rolePrice) {
        this.rolePrice = rolePrice;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }
}
