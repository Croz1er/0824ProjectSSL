package com.deer.ljy.service;

import com.deer.ljy.mapper.ReportMapper;
import com.deer.ljy.pojo.MoneyReport;
import com.deer.ljy.pojo.RoleReport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class ReportServiceImpl implements ReportService {

    @Resource
    private ReportMapper reportMapper;

    @Override
    public List<MoneyReport> selectAllMR() {
        return reportMapper.selectAllMR();
    }

    @Override
    public List<RoleReport> selectAllRR() {
        return reportMapper.selectAllRR();
    }

    @Override
    public int insertMP(MoneyReport moneyReport) {
        return reportMapper.insertMP(moneyReport);
    }

    @Override
    public int insertRR(RoleReport roleReport) {
        return reportMapper.insertRR(roleReport);
    }
}
