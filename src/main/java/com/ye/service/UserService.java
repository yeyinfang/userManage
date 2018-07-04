package com.ye.service;

import com.ye.common.ResponseResult;
import com.ye.pojo.User;

import java.util.Map;

public interface UserService {
    //添加用户
    ResponseResult add(User user);

    //删除用户
    ResponseResult delete(Integer id);

    //重置密码
    ResponseResult resetpwd(Integer id);

    //查询到用户
    ResponseResult get(Integer id);

    //查询到所有的用户
    Map all(Integer page, Integer size);

    //查询到用户的所有角色
    Map roles(Integer id, Integer page, Integer size);

    //用户绑定角色
    ResponseResult addRoles(Integer id, String roleIds);
}
