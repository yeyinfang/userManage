package com.ye.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.ye.common.ResponseResult;
import com.ye.pojo.Permission;
import com.ye.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @program: maven-ssm
 * @description:
 * @author: YF
 * @create: 2018-07-03 23:54
 **/
@Controller
@RequestMapping("/perm")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    //增加
    @RequestMapping("/add")
    @ResponseBody
    public ResponseResult add(Permission permission){
        return permissionService.add(permission);
    }

    //删除
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseResult delete(Integer id){
        return permissionService.delete(id);
    }

    //修改
    @RequestMapping("/update")
    @ResponseBody
    public ResponseResult update(Permission permission){
        return permissionService.update(permission);
    }

    //查找到所有
    @RequestMapping("/all")
    @ResponseBody
    public Map findAll(@RequestParam(required = false,defaultValue = "1")Integer page,
                       @RequestParam(required = false,defaultValue = "10")Integer size){
        return permissionService.findAll(page,size);
    }

}
