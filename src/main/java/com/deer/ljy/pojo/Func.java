package com.deer.ljy.pojo;

import lombok.Data;

import java.util.Date;


@Data
public class Func {

    private Integer id;
    private String funcCode;
    private String funcName;
    private String funcUrl;
    private Integer parentId;
    private Date creationTime;
}
