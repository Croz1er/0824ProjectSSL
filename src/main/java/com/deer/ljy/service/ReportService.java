package com.deer.ljy.service;

import com.deer.ljy.pojo.MoneyReport;
import com.deer.ljy.pojo.RoleReport;

import java.util.List;

public interface ReportService {

    List<MoneyReport> selectAllMR();

    List<RoleReport> selectAllRR();

    int insertMP(MoneyReport moneyReport);

    int insertRR(RoleReport roleReport);



}
