package com.deer.qx.mapper.bank;

        import com.deer.ljy.pojo.User;
        import com.deer.qx.model.account.Account_detail;
        import com.deer.qx.model.account.User_account;
        import org.apache.ibatis.annotations.Insert;
        import org.apache.ibatis.annotations.Param;
        import org.apache.ibatis.annotations.Select;
        import org.apache.ibatis.annotations.Update;

        import java.util.List;

public interface BankMapper {

    //充值
    @Update(value = "update user_account set balance= (balance + #{balance}) , lastUpdateTime=#{lastUpdateTime} where userId =#{userId}")
    int updateAddMoney(User_account user_account);

    @Insert(value = "insert into account_detail (accountId,accountDate,moneyIn,moneyOut,type,credit) values(#{accountId},#{accountDate},#{moneyIn},0,0,#{credit})")
    int insertMoney(Account_detail account_detail);

    //基本账户
    @Select(value = "<script>select * from account_detail left join user_account on  user_account.id  = accountId" +
            "<where>" +
            "<if test=\"staDate !=null and endDate != null\" >" +
            "accountDate  &gt; #{staDate} and accountDate &lt; #{endDate} and" +
            "</if>" +
            " <if test=\"userId!=null and userId !='' \">user_account.userId=#{userId}</if>" +
            "</where></script>")
    List<Account_detail> selectAll(Account_detail account_detail);


    //查询余额
    @Select(value = "select * from user_account where userId=#{userId}")
    User_account selectByBalance(int userId);

//    @Select(value = "select * from account_detail left join user_account on  user_account.id  = account_detail.id WHERE user_account.userId = #{userId}")
//    List<Account_detail> selectAll(Account_detail account_detail);

    //提现
    @Insert(value = "insert into account_detail (accountId,accountDate,moneyOut,type,otherAcountId,moneyIn,credit) values (#{accountId},#{accountDate},#{moneyOut},1,#{otherAcountId},0,#{credit})")
    int insertOut(Account_detail account_detail);

    @Update(value = "update user_account set balance= (balance - #{balance}) where userId =#{userId}")
    int  updateOut(Account_detail account_detail);

    //提现明细
    @Select(value = "<script>select * from account_detail left join user_account on  user_account.id  = accountId" +
            "<where>" +
            "<if test=\"staDate !=null and endDate !=null\" >" +
            "accountDate  &gt; #{staDate} and accountDate &lt; #{endDate} and" +
            "</if>" +
            " <if test=\"userId!=null and userId !='' \">user_account.userId=#{userId}</if>" +
            "</where></script>")
    List<Account_detail> selectOut(Account_detail account_detail);

    //转账

    @Update(value = "update user_account set balance=(balance + #{balance}) where userId =#{userId}")
    int updateTo(User_account user_account);

    @Update(value = "update user_account set balance= (balance - #{balance}) where userId =#{userId}")
    int  updateGo(User_account user_account);

    @Select(value = "select * from au_user where username =#{username}")
    User selectByUsername(User user);

//    @Insert(value = "insert into account_detail (accountId,accountDate,moneyOut,type,otherAcountId,moneyIn) values (#{accountId},#{accountDate},#{moneyOut},1,#{otherAcountId},0)")
//    int insertGo(Account_detail account_detail);

    @Insert(value = "insert into account_detail (accountId,accountDate,moneyOut,type,otherAcountId,moneyIn,credit) values (#{accountId},#{accountDate},#{moneyOut},#{type},#{otherAcountId},#{moneyIn},#{credit})")
    int insertDetail(Account_detail account_detail);


}
