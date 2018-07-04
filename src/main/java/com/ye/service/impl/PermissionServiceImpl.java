package com.ye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ye.common.ResponseResult;
import com.ye.mapper.PermissionMapper;
import com.ye.pojo.Permission;
import com.ye.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: maven-ssm
 * @description:
 * @author: YF
 * @create: 2018-07-03 23:56
 **/
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public ResponseResult add(Permission permission) {
        //先进行查找
        Permission perm = permissionMapper.findPermByName(permission.getPermName());
        if(perm!=null){
            return ResponseResult.error("权限已经存在");
        }
        permissionMapper.addPerm(permission);
        if(permission.getId()!=null){
            return ResponseResult.success("添加成功");
        }else{
            return ResponseResult.error("添加失败");
        }

    }

    @Override
    public ResponseResult delete(Integer id) {
        Permission permission = permissionMapper.findPermById(id);
        if(permission==null){
            return ResponseResult.error("权限不存在");
        }
        int i = permissionMapper.deletePerm(id);
        if(i>0){
            return ResponseResult.success("删除成功");
        }else{
            return ResponseResult.error("删除失败");
        }

    }

    @Override
    public ResponseResult update(Permission permission) {
        Permission dbPermission = permissionMapper.findPermById(permission.getId());
        if(dbPermission==null){
            return ResponseResult.error("权限不存在");
        }
        int i = permissionMapper.updatePerm(permission);
        if(i>0){
            return ResponseResult.success("修改成功");
        }else{
            return ResponseResult.error("修改失败");
        }
    }

    @Override
    public Map findAll(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Permission> permissionList = permissionMapper.findAll();
        PageInfo<Permission> info = new PageInfo<>(permissionList);
        long total = info.getTotal();
        List<Permission> permissions = info.getList();
        Map<String,Object> map = new HashMap<>();
        map.put("rows",permissions);
        map.put("total",total);
        return map;
    }
}
