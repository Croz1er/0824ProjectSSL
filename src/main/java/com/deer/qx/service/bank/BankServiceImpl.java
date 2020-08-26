package com.deer.qx.service.bank;

import com.deer.ljy.pojo.User;
import com.deer.qx.mapper.bank.BankMapper;
import com.deer.qx.model.account.Account_detail;
import com.deer.qx.model.account.User_account;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BankServiceImpl implements BankService {


    @Autowired
    private BankMapper bankMapper;

    @Override
    @Transactional
    public int updateAddMoney(User_account user_account) {
        return bankMapper.updateAddMoney(user_account);
    }


    @Override
    public List<Account_detail> selectAll(Account_detail account_detail) {
        return bankMapper.selectAll(account_detail);
    }

    @Override
    @Transactional
    public int insertOut(Account_detail account_detail) {
        int i = bankMapper.updateOut(account_detail);
        if(i>0){
            int i1 = bankMapper.insertOut(account_detail);
            return i1;
        }
        return 0;
    }

    @Override
    public List<Account_detail> selectOut(Account_detail account_detail) {
        return bankMapper.selectOut(account_detail);
    }


    @Override
    public int transfer(User_account user_account,User user) {
        user_account.setUserId(user.getId());
        int i = bankMapper.updateTo(user_account);
        if(i>0){
            Session session = SecurityUtils.getSubject().getSession();
            User user2 = (User) session.getAttribute("sessionUser");
            user_account.setUserId(user2.getId());
           return bankMapper.updateGo(user_account);
        }
        return 0;
    }

    @Override
    public User selectByUsername(User user) {
        return bankMapper.selectByUsername(user);
    }
}
