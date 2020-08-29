package com.deer.qx.controller.vip;

import com.deer.ljy.pojo.User;
import com.deer.ljy.pojo.base.BaseResult;
import com.deer.qx.service.vip.VipService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/vip")
public class VipController {

    @Autowired
    private VipService vipService;

    //购买会员
    @RequestMapping("/buyVip.do")
    public BaseResult buyVip(User user,Double balance){
        Session session = SecurityUtils.getSubject().getSession();
        User user1 = (User) session.getAttribute("sessionUser");

        user.setLastUpdateTime(new Date());
        user.setId(user1.getId());

        int i = vipService.updateVip(user,balance);
        BaseResult result = new BaseResult();
        if(i>0){
            result.setCode(0);
            return result;
        }else {
            result.setCode(1);
            return result;
        }
    }
}
