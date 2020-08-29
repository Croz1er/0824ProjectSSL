package com.deer.ljy.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class MoneyReport {

    private Integer id;
    private BigDecimal totalMoney;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private Integer type;


}
