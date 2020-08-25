package com.deer.ljy.service;

import com.deer.ljy.mapper.RoleMapper;
import com.deer.ljy.pojo.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAllRole() {
        return roleMapper.selectAllRole();
    }

    @Override
    public Role findRolebyId(Integer id) {
        return roleMapper.selectRolebyId(id);
    }
}
