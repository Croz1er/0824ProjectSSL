package com.deer.ljy.service;

import com.deer.ljy.mapper.RoleMapper;
import com.deer.ljy.pojo.Role;
import com.deer.ljy.pojo.User;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;
    @Resource
    private UserService userService;

    @Override
    public List<Role> findAllRole(int page, int limit) {
        if (page != -1) {
            PageHelper.startPage(page, limit);
        }
        return roleMapper.selectAllRole();
    }

    @Override
    public Role findRolebyId(Integer id) {
        return roleMapper.selectRolebyId(id);
    }

    @Transactional
    @Override
    public String removeRoleById(Integer[] ids) {
        for (Integer id : ids) {
            List<User> allUser = userService.findAllUser();
            System.out.println("======================"+allUser);
            Role role = roleMapper.selectRolebyId(id);
            System.out.println("======"+role.getRoleName());

            for (User user : allUser) {
                System.out.println("======"+user);
                System.out.println("======"+user.getRoleName());
                if (user.getRoleName().equals(role.getRoleName())){
                    return new String("角色:" + id + "号,未删除成功,正在被使用");
                }
            }
            int i = roleMapper.delRoleById(id);
            if (i <= 0) {
                return new String("角色:" + id + "号,未删除成功");
            }
        }
        return null;
    }

    @Transactional
    @Override
    public int updateRoleById(Role role) {
        return roleMapper.updateRoleById(role);
    }

    @Transactional
    @Override
    public int insertRole(Role role) {
        return roleMapper.insertRole(role);
    }
}
