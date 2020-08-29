package com.deer.ljy.controller;

import com.deer.ljy.pojo.Menu;
import com.deer.ljy.pojo.User;
import com.deer.ljy.pojo.base.BaseResult;
import com.deer.ljy.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/meuns")
public class MeunsController {

    @Resource
    private MenuService menuService;


    @RequestMapping("/findAll.do")
    public BaseResult<List<Menu>> getShiros(Integer roleId) throws Exception {
        BaseResult<List<Menu>> result = new BaseResult<>();
        List<Menu> menus = menuService.findByRoleId(roleId);
        result.setCode(0);
        result.setData(menus);
        return result;

    }

    @RequestMapping("/modify.do")
    public BaseResult modifyMenus(Integer roleId, Integer[] funcId) throws Exception{
        User user = (User) (SecurityUtils.getSubject().getSession().getAttribute("sessionUser"));
        String username = user.getUsername();
        System.out.println(username);

        Integer integer = menuService.modifyFuncByRole(roleId, funcId,username);
        BaseResult baseResult = new BaseResult();
        if(integer!=null && integer>0){
            baseResult.setCode(BaseResult.CODE_SUCCESS);
            baseResult.setMsg(BaseResult.MSG_SUCCESS);
        }else{
            baseResult.setCode(BaseResult.CODE_FAILED);
            baseResult.setMsg(BaseResult.MSG_FAILED);
        }
        return baseResult;
    }



}
