package com.deer.ljy.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Role implements Serializable{

    private Integer id;
    private String roleCode;
    private String roleName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    private Integer isStart;
    private String createBy;
}
