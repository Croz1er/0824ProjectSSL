package com.deer.ljy.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Role implements Serializable{

    private Integer id;
    private String roleCode;
    private String roleName;
    private Date createDate;
    private Integer isStart;
    private String createBy;
}
