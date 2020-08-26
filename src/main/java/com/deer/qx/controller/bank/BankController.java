package com.deer.qx.controller.bank;

import com.deer.ljy.pojo.User;
import com.deer.ljy.pojo.base.BaseResult;
import com.deer.qx.mapper.bank.BankMapper;
import com.deer.qx.model.account.Account_detail;
import com.deer.qx.model.account.User_account;
import com.deer.qx.service.bank.BankService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService bankService;
    @Autowired
    private BankMapper bankMapper;



    //充值
    @RequestMapping("/addMoney.do")
    public BaseResult addMoney(User_account user_account){
        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute("sessionUser");
        user_account.setUserId(user.getId());
        int i = bankService.updateAddMoney(user_account);
        BaseResult result = new BaseResult();
        if(i>0){
            result.setCode(0);
            return result;
        }else {
            result.setCode(1);
            return result;
        }
    }

    //基本账户
    @RequestMapping("/findList.do")
    public BaseResult findList(Account_detail account_detail){
        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute("sessionUser");
        System.out.println(account_detail.getAccountDate());
        account_detail.setUserId(user.getId());
        List<Account_detail> account_details = bankService.selectAll(account_detail);
        BaseResult<List> result = new BaseResult<>();
        if(!account_details.isEmpty()){
            result.setData(account_details);
            result.setCode(0);
            result.setMsg(BaseResult.MSG_SUCCESS);
        }
        return result;
    }

    //提现
    @RequestMapping("/addOut.do")
    public BaseResult addOut(Account_detail account_detail){
        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute("sessionUser");
        User_account user_account = bankMapper.selectByBalance(user.getId());
        Integer id = user_account.getId();
        Integer userId = user_account.getUserId();
        account_detail.setUserId(userId);
        account_detail.setAccountId(id);
        account_detail.setOtherAcountId(id.toString());
        account_detail.setAccountDate(new Date());
        int i = bankService.insertOut(account_detail);
        BaseResult result =new BaseResult();
        if(i>0){
            result.setCode(0);
            return result;
        }else {
            result.setCode(1);
            return result;
        }
    }

    //提现明细
    @RequestMapping("/findOut.do")
    public BaseResult findOut(Account_detail account_detail){
        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute("sessionUser");
        User_account user_account = bankMapper.selectByBalance(user.getId());
        account_detail.setUserId(user_account.getUserId());
        List<Account_detail> account_details = bankService.selectOut(account_detail);
        BaseResult result = new BaseResult();
        if(!account_details.isEmpty()){
            result.setCode(0);
            result.setData(account_details);
            return result;
        }
        return result;
    }

    //转账
    @RequestMapping("/transfer.do")
    public BaseResult transfer(User_account user_account,User user){

        int transfer = bankService.transfer(user_account, user);
        BaseResult result = new BaseResult();
        if(transfer>0){
            result.setCode(0);
            return result;
        }
        return result;
    }

    @RequestMapping("/getUid.do")
    public BaseResult getUid(User user){
        User user1 = bankService.selectByUsername(user);
        BaseResult result = new BaseResult();
        if(user1==null){
            result.setCode(1);
            return result;
        }else {
            result.setCode(0);
            result.setData(user1);
            return result;
        }
    }




}

