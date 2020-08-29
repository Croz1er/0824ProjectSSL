package com.deer.ljy.service;

import com.deer.ljy.pojo.Func;
import com.deer.ljy.pojo.Menu;
import com.github.pagehelper.PageInfo;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MenuServiceImpl implements MenuService {


    @Resource
    private FunctionService functionService;


    @Override
    public List<Menu> findByRoleId(Integer roleId) throws Exception {

        //所有权限
        List<Func> funcs = functionService.selectAllFunc(null);
        //角色拥有的权限
        List<Func> funcs2 = functionService.selectAllFunc(roleId);

        //整合成List<Menu>,这里边的每个func就是单个Menu
        List<Menu> menus = new ArrayList<>();
        int i = 1;
        for (Func func : funcs) {
            Menu menu = new Menu();
            int j = 0;
            j = i++;
            //父子关系
            menu.setAuthority(func.getFuncCode());
            menu.setAuthorityId(func.getId());
            menu.setAuthorityName(func.getFuncName());
            menu.setCreateTime(func.getCreationTime());
            menu.setIsMenu(1);
            menu.setMenuUrl(func.getFuncUrl());
            menu.setOrderNumber(j);
            menu.setUpdateTime(new Date());
            menu.setParentId(func.getParentId());
            //标识出选中的菜单
            for (Func checkedFunc : funcs2) {
                if (func.getId().intValue() == checkedFunc.getId().intValue()) {
                    menu.setChecked(true);
                    break;
                }
            }
            menus.add(menu);
        }
        return menus;

    }

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    @Override
    public Integer modifyFuncByRole(Integer roleId, Integer[] funcId, String createBy) throws Exception {
        //1.先根据roleId删除权限
        int remove = functionService.deleteFuncByRoleId(roleId);
        //2.再根据roleId增加权限
        Integer integer = 0;
        if (funcId != null) {
            for (Integer id : funcId) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String format1 = format.format(new Date());
                System.out.println(format1);
                integer += functionService.insertFuncByRoleId(roleId, id, format1, createBy);
            }
        }
        return remove + integer;
//       return null;
    }
}
