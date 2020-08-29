package com.deer.ljy.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class Func {

    private Integer id;
    private String funcCode;
    private String funcName;
    private String funcUrl;
    private Integer parentId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationTime;
}
