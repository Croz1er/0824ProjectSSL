package com.deer.qx.controller.goods;




import com.deer.ljy.pojo.User;
import com.deer.ljy.pojo.base.BaseResult;
import com.deer.qx.model.goods.Cart_goods;
import com.deer.qx.model.goods.Goods_info;
import com.deer.qx.service.goods.GoodsService;
import com.github.pagehelper.PageHelper;
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
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    //商品信息
    @RequestMapping("/list.do")
    public BaseResult list(Goods_info goods_info,int page,int limit){
        BaseResult<List> result = new BaseResult<>();
        List<Goods_info> goods_infos = goodsService.selectAll(goods_info,page,limit);
        if(!goods_infos.isEmpty()){
            long total = PageInfo.of(goods_infos).getTotal();
            result.setCount((int)total);
            result.setData(goods_infos);
            result.setCode(0);
            result.setMsg(BaseResult.MSG_SUCCESS);
        }
        return result;
    }

    //删除单商品
    @RequestMapping("/delOne.do")
    public BaseResult delOne(String isid){

        int i = goodsService.delById(isid);
        BaseResult result = new BaseResult();
        if(i>0){
            result.setCode(0);
            return result;
        }else {
            result.setCode(1);
            return result;
        }
    }

    //更新商品
    @RequestMapping("/updateGoods.do")
    public BaseResult updateGoods(Goods_info goods_info){
        goods_info.setLastUpdateTime(new Date());
        int i = goodsService.updateGoods(goods_info);
        BaseResult result = new BaseResult();
        if(i>0){
            result.setCode(0);
            return result;
        }else {
            result.setCode(1);
            return result;
        }
    }

    //添加商品
    @RequiresPermissions("/shop")
    @RequestMapping("/addGoods.do")
    public BaseResult addGoods(Goods_info goods_info){
        System.out.println(goods_info.getCreateTime());
        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute("sessionUser");
        goods_info.setCreatedBy(user.getUsername());
        goods_info.setLastUpdateTime(new Date());

        int i = goodsService.insertGoods(goods_info);
        BaseResult result = new BaseResult();
        if(i>0){
            result.setCode(0);
            return result;
        }else {
            result.setCode(1);
            return result;
        }
    }


    //添加购物车
    @RequiresPermissions({"/shop/shopadd.do","/shop"})
    @RequestMapping("/addCar.do")
    public BaseResult addCar(Cart_goods cart_goods){
        Cart_goods cart_goods1 = goodsService.selectCar(cart_goods);
        Session session = SecurityUtils.getSubject().getSession();
        User user = (User)session.getAttribute("sessionUser");
        cart_goods.setCreateBy(user.getUsername());
        cart_goods.setCreateTime(new Date());
        cart_goods.setLastUpdateTime(new Date());
        BaseResult result = new BaseResult();
        if(cart_goods1==null || cart_goods1.equals("")){
            int i = goodsService.insertCart(cart_goods);
            int i1 = goodsService.updateCartGoods(cart_goods);
            if(i>0){
                result.setCode(0);
                return result;
            }else {
                result.setCode(1);
                return result;
            }
        }
        else {
            int i = goodsService.updateCart(cart_goods);
            int i1 = goodsService.updateCartGoods(cart_goods);
            if(i>0){
                result.setCode(0);
                return result;
            }else {
                result.setCode(1);
                return result;
            }
        }
    }

    //查库存
    @RequestMapping("/findNum.do")
    public BaseResult findNum(Goods_info goods_info){
        Goods_info goods_info1 = goodsService.selectFindNum(goods_info);
        BaseResult result = new BaseResult();
        if(goods_info1!=null){
            result.setData(goods_info1);
            result.setCode(0);
            return result;
        }else {
            result.setCode(1);
            return result;
        }
    }

    //更改状态
//    @RequiresPermissions("/shop")
    @RequestMapping("/updateState.do")
    public BaseResult updateState(Goods_info goods_info){

        int i = goodsService.updateState(goods_info);
        BaseResult result = new BaseResult();
        if(i>0){
            result.setCode(0);
            return result;
        }else {
            result.setCode(1);
            return result;
        }

    }


    //模糊查询
    @RequestMapping("/findVague.do")
    public BaseResult findVague(Goods_info goods_info){
        List<Goods_info> vague = goodsService.findVague(goods_info);
        BaseResult result = new BaseResult();
        if(!vague.isEmpty()){
            result.setCode(0);
            result.setData(vague);
            return result;
        }else {
            result.setCode(1);
            return result;
        }
    }



}
