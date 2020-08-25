package com.deer.ljy.service;

import com.deer.ljy.pojo.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAllRole();

    Role findRolebyId(Integer id);


}
