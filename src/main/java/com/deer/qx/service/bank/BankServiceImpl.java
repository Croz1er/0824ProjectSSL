package com.deer.qx.service.bank;

import com.deer.ljy.pojo.User;
import com.deer.qx.mapper.bank.BankMapper;
import com.deer.qx.model.account.Account_detail;
import com.deer.qx.model.account.User_account;
import com.github.pagehelper.PageHelper;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    public List<Account_detail> selectAll(Account_detail account_detail,int page,int limit) {
        PageHelper.startPage(page,limit);
        return bankMapper.selectAll(account_detail);
    }

    @Override
    @Transactional
    public int insertOut(Account_detail account_detail) {
        int i = bankMapper.updateOut(account_detail);
        if(i>0){
            Session session = SecurityUtils.getSubject().getSession();
            User user =(User) session.getAttribute("sessionUser");
            User_account user_account = bankMapper.selectByBalance(user.getId());
            account_detail.setCredit(user_account.getBalance());
            int i1 = bankMapper.insertOut(account_detail);
            return i1;
        }
        return 0;
    }

    @Override
    public List<Account_detail> selectOut(Account_detail account_detail,int page,int limit) {
        PageHelper.startPage(page,limit);
        return bankMapper.selectOut(account_detail);
    }


    @Override
    public int transfer(User_account user_account,User user) {
        user_account.setUserId(user.getId());
        int i = bankMapper.updateTo(user_account);
        User_account user_account1 = bankMapper.selectByBalance(user.getId());
        if(i>0){
            Session session = SecurityUtils.getSubject().getSession();
            User user2 = (User) session.getAttribute("sessionUser");
            User_account user_account2 = bankMapper.selectByBalance(user2.getId());

            //添加转入记录
            Account_detail detailTo = new Account_detail();
            detailTo.setAccountDate(new Date());
            detailTo.setMoneyIn(user_account.getBalance());
            detailTo.setAccountId(user_account1.getId());
            detailTo.setType(3);
            detailTo.setMoneyOut(0.0);
            detailTo.setOtherAcountId(user2.getUsername());
            detailTo.setCredit(user_account2.getBalance()+user_account.getBalance());
            bankMapper.insertDetail(detailTo);

            //添加转出记录
            Account_detail detailOut = new Account_detail();
            detailOut.setAccountDate(new Date());
            detailOut.setMoneyIn(0.0);
            detailOut.setAccountId(user_account2.getId());
            detailOut.setType(2);
            detailOut.setMoneyOut(user_account.getBalance());
            detailOut.setOtherAcountId(user.getUsername());
            detailOut.setCredit(user_account2.getBalance()-user_account.getBalance());
            bankMapper.insertDetail(detailOut);



            user_account.setUserId(user2.getId());
           return bankMapper.updateGo(user_account);
        }
        return 0;
    }

    @Override
    public User selectByUsername(User user) {
        return bankMapper.selectByUsername(user);
    }

    @Override
    public User_account selectByBalance(int userId) {
        return bankMapper.selectByBalance(userId);
    }
}
