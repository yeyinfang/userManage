package com.ye.controller;

import com.github.pagehelper.PageHelper;
import com.ye.common.ResponseResult;
import com.ye.pojo.User;
import com.ye.service.UserService;
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
 * @create: 2018-07-03 15:50
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    //测试
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    //添加用户
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody//这个注解的目的是为了返回json数据到页面上
    public ResponseResult add(User user){
        return userService.add(user);
    }

    //删除用户
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult delete(Integer id){
        return userService.delete(id);
    }

    //重置密码
    @RequestMapping(value = "/resetpwd",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult resetpwd(Integer id){
        return userService.resetpwd(id);
    }

    //查询用户
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult get(Integer id){
        return userService.get(id);
    }

    //查询所以的用户
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ResponseBody
    public Map all(@RequestParam(required = false, defaultValue = "1") Integer page,
                   @RequestParam(required = false, defaultValue = "10")Integer size){

        return userService.all(page,size);
    }
}
