package com.deer.qx.model.account;

import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Account_detail implements Serializable {

    private Integer id;
    //关联用户账户表
    private Integer accountId;
    //记录入账或出账日期
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date accountDate;
    @Transient
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date accountDate1;

    public Date getAccountDate1() {
        return accountDate1;
    }

    public void setAccountDate1(Date accountDate1) {
        this.accountDate1 = accountDate1;
    }

    //入账
    private Double moneyIn;
    //出账
    private Double moneyOut;
    //0充值,1提现,2消费,3收益
    private Integer type;
    //交易方账户
    private String otherAcountId;
    @Transient
    private  Double balance;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Transient
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

    public Double getMoneyIn() {
        return moneyIn;
    }

    public void setMoneyIn(Double moneyIn) {
        this.moneyIn = moneyIn;
    }

    public Double getMoneyOut() {
        return moneyOut;
    }

    public void setMoneyOut(Double moneyOut) {
        this.moneyOut = moneyOut;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOtherAcountId() {
        return otherAcountId;
    }

    public void setOtherAcountId(String otherAcountId) {
        this.otherAcountId = otherAcountId;
    }
}
