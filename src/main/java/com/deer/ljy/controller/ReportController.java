package com.deer.ljy.controller;

import com.deer.ljy.pojo.MoneyReport;
import com.deer.ljy.pojo.RoleReport;
import com.deer.ljy.pojo.base.BaseResult;
import com.deer.ljy.service.ReportService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Resource
    private ReportService service;

    /**
     * 获取MR
     * @param
     * @return
     */
    @RequestMapping("/getMR.do")
    public BaseResult<List<MoneyReport>> getReportMR(){
        BaseResult<List<MoneyReport>> result = new BaseResult<>();
        List<MoneyReport> allMR = service.selectAllMR();
        result.setData(allMR);
        result.setCode(0);
        return result;
    }

    /**
     * 获取RR
     * @param
     * @return
     */
    @RequestMapping("/getRR.do")
    public BaseResult<List<RoleReport>> getReportRR(){
        BaseResult<List<RoleReport>> result = new BaseResult<>();
        List<RoleReport> allRR = service.selectAllRR();
        result.setData(allRR);
        result.setCode(0);
        return result;
    }
}
