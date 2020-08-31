package com.deer.qx.service.bank;

import com.deer.ljy.pojo.User;
import com.deer.qx.model.account.Account_detail;
import com.deer.qx.model.account.User_account;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BankService {

    int updateAddMoney(User_account user_account);

    List<Account_detail> selectAll(Account_detail account_detail, int page, int limit);

    int insertOut(Account_detail account_detail);

    List<Account_detail> selectOut(Account_detail account_detail, int page, int limit);

    int transfer(User_account user_account, User user);

    User selectByUsername(User user);

    User_account selectByBalance(int userId);


    int insertUserAccount();


}
