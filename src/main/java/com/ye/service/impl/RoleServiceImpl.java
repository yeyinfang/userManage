package com.ye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ye.common.ResponseResult;
import com.ye.mapper.RoleMapper;
import com.ye.pojo.Role;
import com.ye.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: maven-ssm
 * @description:
 * @author: YF
 * @create: 2018-07-03 22:31
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public ResponseResult addRole(Role role) {
        //首先就是查询看是否有这个角色---根据名字
        Role dbRole = roleMapper.findRoleByName(role.getRoleName());
        if(dbRole!=null){
            //证明有这个角色了，所以要提示
            return ResponseResult.error("该角色已存在！");
        }
        //进行增加
        roleMapper.addRole(role);
        if(role.getId()!=null){
            return ResponseResult.success("角色增加成功！");
        }else{
            return ResponseResult.error("角色添加失败！");
        }

    }

    @Override
    public ResponseResult deleteRole(Integer id) {
        //先查找到是否有这个用户存在
        Role role = roleMapper.findRoleById(id);
        if(role==null){
            return ResponseResult.error("该角色不存在！");
        }
        int i = roleMapper.deleteRole(id);
        if(i>0){
            return ResponseResult.success("删除成功！");
        }else{
            return ResponseResult.error("删除失败！");
        }
    }

    @Override
    public ResponseResult updateRole(Role role) {
        Role dbRole = roleMapper.findRoleById(role.getId());
        if(dbRole==null){
            return ResponseResult.error("角色不存在！");
        }
        int count = roleMapper.updateRole(role);
        if(count>0){
            return ResponseResult.success("角色修改成功！");
        }else{
            return ResponseResult.error("角色修改失败！");
        }
    }

    @Override
    public Map findAll(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        //查询出所有的
        List<Role> roleList = roleMapper.findAll();
        PageInfo<Role> info = new PageInfo<>(roleList);
        long total = info.getTotal();
        List<Role> list = info.getList();
        Map<String,Object> map= new HashMap<>();
        map.put("total",total);
        map.put("rows",list);
        return map;
    }

    @Override
    public ResponseResult addPerms(Integer id, String perm_ids) {
        Role dbRole = roleMapper.findRoleById(id);
        if(dbRole==null){
            return ResponseResult.error("角色不存在！");
        }
        //切割id
        String[] permIds = perm_ids.split(",");

        int count = roleMapper.addPerm(id,permIds);

        if (count == permIds.length){
            return ResponseResult.success("绑定权限成功");
        }else{
            return ResponseResult.error("绑定权限失败");
        }

    }
}
