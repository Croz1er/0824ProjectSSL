package com.deer.ljy.mapper;

import com.deer.ljy.pojo.MoneyReport;
import com.deer.ljy.pojo.RoleReport;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReportMapper {

    /**
     * 查找所有money
     * @return
     */
    @Select("select * from report2 ORDER BY createTime DESC")
    List<MoneyReport> selectAllMR();

    /**
     * 查找所有会员统计
     */
    @Select("select * from report ORDER BY createTime DESC")
    List<RoleReport> selectAllRR();

    /**
     * 生成money统计
     */
    @Insert("insert into report2(totalMoney,creatMoney,type) values(#{totalMoney},#{creatMoney},#{type})")
    int insertMP(MoneyReport moneyReport);

    /**
     * 生成会员人数统计
     */
    @Insert("insert into report2(userNum,roleId,roleName,createTime) values(#{userNum},#{roleId},#{roleName},#{createTime})")
    int insertRR(RoleReport roleReport);

}
