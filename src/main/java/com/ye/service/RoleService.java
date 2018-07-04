package com.ye.service;

import com.ye.common.ResponseResult;
import com.ye.pojo.Role;

import java.util.Map;

public interface RoleService {
    //添加角色
    ResponseResult addRole(Role role);

    //删除角色
    ResponseResult deleteRole(Integer id);

    //修改角色
    ResponseResult updateRole(Role role);

    //查找所有的，根据分页
    Map findAll(Integer page, Integer size);

    //绑定权限
    ResponseResult addPerms(Integer id, String perm_ids);

    //查找所拥有的权限
    Map find_perm(Integer id, Integer page, Integer size);
}
