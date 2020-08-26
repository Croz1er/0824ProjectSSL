package com.deer.ljy.controller;

import com.deer.ljy.pojo.Role;
import com.deer.ljy.pojo.base.BaseResult;
import com.deer.ljy.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @RequestMapping("/findAllRole.do")
    public BaseResult<List> getAllRole(){
        BaseResult<List> baseResult = new BaseResult<>();
        List<Role> allRole = roleService.findAllRole();
        if (allRole == null ||allRole.isEmpty() ){
            baseResult.setCode(1);
        }else {
            baseResult.setCode(0);
            baseResult.setData(allRole);
        }

        return baseResult;

    }


}
