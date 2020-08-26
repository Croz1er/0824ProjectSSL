package com.deer.qx.model.au;

import java.io.Serializable;
import java.util.Date;

public class Au_user implements Serializable {

    private Integer id;
    //登录账号
    private String username;
    //登录密码（初始密码为证件号码后六位）
    private String password;
    //二级密码（初始密码为证件号码后六位）
    private String password2;
    //用户真实姓名
    private String realName;
    //性别
    private String sex;
    //生日
    private Date birthday;
    //证件类型id,来源于数据字典表 data_dictionary 中 typeCode =’CARD_TYPE’的 valueId
    private String cardType;
    //证件类型名称,来源于数据字典表 data_dictionary 中 typeCode =’CARD_TYPE’的 valueName
    private String cardTypeName;
    //证件号码
    private String idCard;
    //收货国家
    private String country;
    //手机
    private String mobile;
    //email
    private String email;
    //收获地址
    private String userAddress;
    //邮编
    private String postCode;
    //注册时间
    private Date createTime;
    //推荐人id（默认为当前登录用户id）
    private Integer referId;
    //推荐人编码（默认为当前登录用户loginCode）
    private String referCode;
    //所属角色ID
    private Integer roleId;
    //所属角色名称
    private String roleName;
    //是否启用（1、启用2、未启用）
    private Integer isStart;
    //最新更新时间
    private Date lastUpdateTime;
    //最后登录时间
    private Date lastLoginTime;
    //开户卡号
    private String bankAccount;
    //开户行
    private String bankName;
    //开户人
    private String accountHolder;
    //身份证照片存放路径
    private String idCardPicPath;
    //银行卡照片存放路径
    private String bankPicPath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardTypeName() {
        return cardTypeName;
    }

    public void setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getReferId() {
        return referId;
    }

    public void setReferId(Integer referId) {
        this.referId = referId;
    }

    public String getReferCode() {
        return referCode;
    }

    public void setReferCode(String referCode) {
        this.referCode = referCode;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getIsStart() {
        return isStart;
    }

    public void setIsStart(Integer isStart) {
        this.isStart = isStart;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getIdCardPicPath() {
        return idCardPicPath;
    }

    public void setIdCardPicPath(String idCardPicPath) {
        this.idCardPicPath = idCardPicPath;
    }

    public String getBankPicPath() {
        return bankPicPath;
    }

    public void setBankPicPath(String bankPicPath) {
        this.bankPicPath = bankPicPath;
    }
}
