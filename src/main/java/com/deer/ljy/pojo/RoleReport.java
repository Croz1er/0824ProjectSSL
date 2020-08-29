package com.deer.ljy.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class RoleReport {

    private Integer id;
    private Integer userNum;
    private Integer roleId;
    private String roleName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

}
