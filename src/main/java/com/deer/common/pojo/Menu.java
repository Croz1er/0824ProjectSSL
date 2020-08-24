package com.deer.common.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Menu implements Serializable {

    private Integer authorityId;
    private String authorityName;
    private Integer orderNumber;
    private String menuUrl;
    private String menuIcon;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String authority;
    @JsonProperty("LAY_CHECKED")
    private boolean checked=false;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private Integer isMenu;
    private Integer parentId;
}
