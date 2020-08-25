package com.deer.ljy.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    /*test*/
    private Integer id;
    private String username;
    private String password;
    private String password2;
    private String realName;
    private String sex;
    private Date birthday;
    private String cardType;
    private String cardTypeName;
    private String idCard;
    private String country;
    private String mobile;
    private String email;
    private String postCode;
    private String userAddress;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private Integer referId;
    private String referCode;
    private Integer roleId;
    private String roleName;
    private Integer isStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastUpdateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastLoginTime;
    private String bankAccount;
    private String bankName;
    private String accountHolder;
    private String idCardPicPath;
    private String bankPicPath;

}
