package com.deer.qx.controller.cart;

import com.deer.ljy.pojo.User;
import com.deer.ljy.pojo.base.BaseResult;
import com.deer.qx.model.account.Account_detail;
import com.deer.qx.model.account.User_account;
import com.deer.qx.model.goods.Cart_goods;
import com.deer.qx.service.cart.CartService;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    //查看购物车列表
    @RequiresPermissions({"/shop/selectCar.do","/shop"})
    @RequestMapping("/findAll.do")
    public BaseResult findAll(Cart_goods cart_goods,int page,int limit){

        Session session = SecurityUtils.getSubject().getSession();
        User user =(User)session.getAttribute("sessionUser");
        cart_goods.setCreateBy(user.getUsername());
        List<Cart_goods> cart_goods1 = cartService.selectAll(cart_goods,page,limit);
        BaseResult result = new BaseResult();
        if(!cart_goods1.isEmpty()){
            long total = PageInfo.of(cart_goods1).getTotal();
            result.setCount((int)total);
            result.setCode(0);
            result.setData(cart_goods1);
            return result;
        }else {
            result.setCode(1);
            return result;
        }
    }

    //删除购物车
    @RequestMapping("/delCart.do")
    public BaseResult delCart(Cart_goods cart_goods){
        int i = cartService.deleteCart(cart_goods);
        BaseResult result = new BaseResult();
        if(i>0){
            result.setCode(0);
            return result;
        }
        else {
            result.setCode(1);
            return result;
        }
    }





}
