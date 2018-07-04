package com.ye.service;

import com.ye.common.ResponseResult;
import com.ye.pojo.Permission;

import java.util.Map;

public interface PermissionService {
    //添加权限
    ResponseResult add(Permission permission);

    //删除权限
    ResponseResult delete(Integer id);

    //更新权限
    ResponseResult update(Permission permission);

    //查找到所有的
    Map findAll(Integer page,Integer size);
}
