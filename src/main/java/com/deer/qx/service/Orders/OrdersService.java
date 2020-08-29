package com.deer.qx.service.Orders;

import com.deer.qx.model.account.Account_detail;
import com.deer.qx.model.account.User_account;
import com.deer.qx.model.order.Order_goods;

import java.util.List;

public interface OrdersService {

    int insertOrders(Order_goods order_goods);

    int  updateOut(User_account user_account);

    List<Order_goods> selectAll(Order_goods order_goods,int page, int limit);

    int deleteOrders(String isid);


}
