package com.deer.qx.service.vip;

import com.deer.ljy.pojo.User;
import com.deer.qx.mapper.vip.VipMapper;
import com.deer.qx.model.account.Account_detail;
import com.deer.qx.model.account.User_account;
import com.deer.qx.model.order.Order_goods;
import com.deer.qx.model.order.Order_info;
import com.deer.qx.model.order.Order_user;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class VipServiceImpl implements VipService {

    @Autowired
    private VipMapper vipMapper;

    @Override
    @Transactional
    public int updateVip(User user, Double balance) {
        Session session = SecurityUtils.getSubject().getSession();
        User user1 = (User) session.getAttribute("sessionUser");
        User_account user_account = new User_account();
        user_account.setBalance(balance);
        user_account.setUserId(user1.getId());

        Order_info order_info = new Order_info();
        int i = (int)System.currentTimeMillis() / 1000;
        order_info.setCreateBy(user.getUsername());
        order_info.setOrderCode(i);
        order_info.setCreateTime(new Date());
        order_info.setLastUpdateTime(new Date());
        order_info.setOrderPrice(balance);
        order_info.setStatus(1);
        order_info.setUserId(user1.getId());
        vipMapper.insertOrdersInfo(order_info);

        Order_user order_user = new Order_user();
        order_user.setRolename(user.getRoleName());
        order_user.setRolePrice(balance);
        order_user.setRoleId(user.getRoleId());
        order_user.setCreateBy(user.getUsername());
        order_user.setCreateDateTime(new Date());
        order_user.setOrderinfoId(vipMapper.selectGetId());
        vipMapper.insertOrdersUser(order_user);

        User_account user_account1 = vipMapper.selectByBalance(user1.getId());

        Account_detail account_detail = new Account_detail();
        account_detail.setCredit(user_account1.getBalance());
        account_detail.setAccountId(user_account1.getId());
        account_detail.setAccountDate(new Date());
        account_detail.setMoneyOut(balance);
        account_detail.setMoneyIn(0.0);
        account_detail.setType(2);
        account_detail.setOtherAcountId("无");
        vipMapper.insertAccount_detail(account_detail);

        vipMapper.updateBalance(user_account);
        return vipMapper.updateVip(user);
    }
}
