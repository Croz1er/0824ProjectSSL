package com.deer.qx.service.Orders;

import com.deer.ljy.pojo.User;
import com.deer.qx.mapper.Orders.OrdersMapper;
import com.deer.qx.model.account.Account_detail;
import com.deer.qx.model.account.User_account;
import com.deer.qx.model.order.Order_goods;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    @Transactional
    public int insertOrders(Order_goods order_goods) {
        int i = (int)System.currentTimeMillis() / 1000;
        order_goods.setOrderInfoId(i);
        order_goods.setCreateTime(new Date());
        order_goods.setLastUpdateTime(new Date());
        int i1 = ordersMapper.insertOrdersGoods(order_goods);

        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute("sessionUser");
        order_goods.setStatus(1);
        order_goods.setOrderCode(i);
        order_goods.setUserId(user.getId());

        int i2 = ordersMapper.insertOrdersInfo(order_goods);

        int i3 = ordersMapper.deleteCart(order_goods);

        if (i1+i2+i3>=3){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    @Transactional
    public int updateOut(User_account user_account) {
        return ordersMapper.updateOut(user_account);
    }


    @Override
    public List<Order_goods> selectAll(Order_goods order_goods,int page, int limit) {
         PageHelper.startPage(page, limit);
        return ordersMapper.selectAll(order_goods);
    }

    @Override
    public int deleteOrders(String isid) {
        System.out.println(isid);
        if(isid!=null || isid.equals("")){
            String ids [] = isid.split(",");
            for(String sid :ids){
                if(sid!=null || sid!=""){
                    int i = Integer.parseInt(sid);
                    int i1 = ordersMapper.deleteOrders(i);
                }else {
                    return 0;
                }
            }
            return 1;
        }
        return 0;
    }
}
