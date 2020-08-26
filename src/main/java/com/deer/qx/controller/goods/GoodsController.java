package com.deer.qx.controller.goods;




import com.deer.ljy.pojo.User;
import com.deer.ljy.pojo.base.BaseResult;
import com.deer.qx.model.goods.Goods_info;
import com.deer.qx.model.shop.Shopcart;
import com.deer.qx.service.goods.GoodsService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
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
    public BaseResult list(){
        System.out.println(11);
        BaseResult<List> result = new BaseResult<>();
        List<Goods_info> goods_infos = goodsService.selectAll();
        if(!goods_infos.isEmpty()){
            result.setData(goods_infos);
            result.setCode(0);
            result.setMsg(BaseResult.MSG_SUCCESS);
        }
        return result;
    }

    //添加购物车
    @RequestMapping("/add.do")
    public BaseResult addCar(Goods_info goods_info){
        Date crreateTime = goods_info.getCrreateTime();
        System.out.println(crreateTime+"============================");
        Session session = SecurityUtils.getSubject().getSession();
        User session1 = (User)session.getAttribute("sessionUser");
        session1.getId();
        return null;

    }

}
