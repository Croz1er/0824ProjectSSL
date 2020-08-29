package com.deer.ljy.service;

import com.deer.ljy.pojo.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAllRole(int page, int limit);

    Role findRolebyId(Integer id);



    String removeRoleById(Integer [] ids);

    int updateRoleById(Role role);

    int insertRole(Role role);


}
