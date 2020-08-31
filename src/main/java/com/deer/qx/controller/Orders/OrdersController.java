package com.deer.qx.controller.Orders;

import com.deer.ljy.pojo.User;
import com.deer.ljy.pojo.base.BaseResult;
import com.deer.qx.model.account.Account_detail;
import com.deer.qx.model.account.User_account;
import com.deer.qx.model.order.Order_goods;
import com.deer.qx.model.order.Order_info;
import com.deer.qx.service.Orders.OrdersService;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    //添加订单信息
    @RequestMapping("/addOrders.do")
    public BaseResult addOrders(Order_goods order_goods){

        int i = ordersService.insertOrders(order_goods);
        BaseResult result = new BaseResult();
        if(i>0){
            result.setCode(0);
            return result;
        }else {
            result.setCode(1);
            return result;
        }
    }


    //结算
    @RequestMapping("/settlement.do")
    public BaseResult addOut(User_account user_account){
        user_account.setLastUpdateTime(new Date());
        int i = ordersService.updateOut(user_account);
        BaseResult result = new BaseResult();
        if(i>0){
            result.setCode(0);
            return result;
        }else {
            result.setCode(1);
            return result;
        }
    }

    //订单详情
    @RequiresPermissions({"/shop/selectOrders.do","/shop"})
    @RequestMapping("/findOrderAll.do")
    public BaseResult findOrderAll(Order_goods order_goods,int page,int limit){
        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute("sessionUser");
        order_goods.setCreateBy(user.getUsername());
        System.out.println(order_goods.getCreateBy());
        List<Order_goods> order_goods1 = ordersService.selectAll(order_goods,page, limit );
        BaseResult result = new BaseResult();
        if(!order_goods1.isEmpty()){
            long total = PageInfo.of(order_goods1).getTotal();
            result.setCode(0);
            result.setData(order_goods1);
            result.setCount((int)total);
            return result;
        }else {
            result.setCode(0);
            return result;
        }
    }

    //订单删除
    @RequestMapping("/delOrders.do")
    public BaseResult delOrders(String isid){
        System.out.println(1);
        int i = ordersService.deleteOrders(isid);
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
