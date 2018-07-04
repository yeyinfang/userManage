package com.ye.controller;

import com.ye.common.ResponseResult;
import com.ye.pojo.Role;
import com.ye.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @program: maven-ssm
 * @description:
 * @author: YF
 * @create: 2018-07-03 22:30
 **/
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    //添加角色
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult add(Role role){
        return roleService.addRole(role);
    }

    //删除角色
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult delete(Integer id){
        return roleService.deleteRole(id);
    }

    //修改角色
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult update(Role role){
        return roleService.updateRole(role);
    }

    //查询出所有的
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ResponseBody
    public Map findAll(@RequestParam(required = false,defaultValue = "1") Integer page,
                       @RequestParam(required = false,defaultValue = "10") Integer size){
        return roleService.findAll(page,size);
    }

    //角色绑定权限
    @RequestMapping(value = "/add_perms",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult addPerms(Integer id ,String perm_ids){
        return roleService.addPerms(id,perm_ids);
    }

    //根绝角色id查找到自己所拥有的权限
    @RequestMapping(value = "find_perm",method = RequestMethod.POST)
    @ResponseBody
    public Map find_perm(Integer id,@RequestParam(required = false,defaultValue = "1") Integer page,
                        @RequestParam(required = false,defaultValue = "10")Integer size){
        return roleService.find_perm(id,page,size);
    }
}
