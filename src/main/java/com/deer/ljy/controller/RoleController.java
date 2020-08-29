package com.deer.ljy.controller;

import com.deer.ljy.pojo.Func;
import com.deer.ljy.pojo.Role;
import com.deer.ljy.pojo.User;
import com.deer.ljy.pojo.base.BaseResult;
import com.deer.ljy.service.FunctionService;
import com.deer.ljy.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @Resource
    private FunctionService functionService;

    /**
     * 查询所有角色
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/findAllRole.do")
    public BaseResult<List> getAllRole(int page,int limit) {
        BaseResult<List> baseResult = new BaseResult<>();
        List<Role> allRole = roleService.findAllRole(page, limit);
        if (allRole == null || allRole.isEmpty()) {
            baseResult.setCode(1);
        } else {
            int total = (int) PageInfo.of(allRole).getTotal();
            baseResult.setCount(total);
            baseResult.setCode(0);
            baseResult.setData(allRole);
        }
        return baseResult;
    }

    /**
     * 删除角色
     * @param ids
     * @return
     */
    @RequestMapping("/delRoles.do")
    public BaseResult deleteRolles(@Param("ids") Integer [] ids){
        BaseResult result = new BaseResult();
        String mess = roleService.removeRoleById(ids);
        System.out.println(mess);
        if (mess == null){
            result.setCode(0);
        }else {
            result.setCode(1);
            result.setMsg(mess);
        }
        return result;
    }
    /**
     * 编辑角色
     * @param role
     * @return
     */
    @RequestMapping("/updateRole.do")
    public BaseResult upDateRolles(Role role){
        BaseResult result = new BaseResult();
        System.out.println(role);
        if (role.getIsStart()==null){
            role.setIsStart(0);
        }
        int i = roleService.updateRoleById(role);
        if (i>0){
            result.setCode(0);
        }else {
            result.setCode(1);
        }
        return result;
    }

    /**
     * 新增角色
     * @param role
     * @return
     */
    @RequestMapping("/addRole.do")
    public BaseResult addRole(Role role){
        BaseResult result = new BaseResult();
        if (role.getIsStart()==null){
            role.setIsStart(0);
        }
        System.out.println("============"+role);
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("sessionUser");

        role.setCreateBy(user.getUsername());
        role.setCreateDate(new Date());

        int i = roleService.insertRole(role);
        if (i>0){
            result.setCode(0);
        }else {
            result.setCode(1);
        }
        return result;
    }


    /**
     * 查询所有权限
     * @return
     */
    @RequestMapping("/findAllfunc.do")
    public BaseResult<List<Func>> getAllFunc(Integer roleId) {
        System.out.println("进来了");
        BaseResult<List<Func>> baseResult = new BaseResult<>();
        List<Func> funcs = functionService.selectAllFunc(roleId);
        System.out.println("123123"+funcs);
        if (!funcs.isEmpty()) {
            baseResult.setCode(0);
            baseResult.setData(funcs);
        } else {
            baseResult.setCode(1);
        }
        return baseResult;
    }

    /**
     * 添加权限
     * @param func
     * @return
     */
    @RequestMapping("/addFunc.do")
    public BaseResult addFunc(Func func) {
        BaseResult result = new BaseResult();
        func.setCreationTime(new Date());
        System.out.println(func);
        int i = functionService.insertFunc(func);
        if (i > 0) {
            result.setCode(0);
        } else {
            result.setCode(1);
        }
        return result;
    }

    /**
     * 删除权限
     * @param id
     * @return
     */
    @RequestMapping("/delFunc.do")
    public BaseResult deleteFunc(Integer id) {
        BaseResult result = new BaseResult();
        int i = functionService.deleteFunc(id);
        if (i > 0) {
            result.setCode(0);
        } else {
            result.setCode(1);
        }
        return result;
    }


    /**
     * 修改权限信息
     * @param func
     * @return
     */
    @RequestMapping("/updateFunc.do")
    public BaseResult updateFunc(Func func) {
        BaseResult result = new BaseResult();
        int i = functionService.updateFunc(func);
        if (i > 0) {
            result.setCode(0);
        } else {
            result.setCode(1);
        }
        return result;
    }


}
