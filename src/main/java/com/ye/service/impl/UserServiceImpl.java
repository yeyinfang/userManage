package com.ye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import com.ye.common.ResponseResult;
import com.ye.mapper.UserMapper;
import com.ye.pojo.User;
import com.ye.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: maven-ssm
 * @description:
 * @author: YF
 * @create: 2018-07-03 16:44
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ResponseResult add(User user) {
        //先到数据库进行查找看是否存在
        User dbUser = userMapper.findUserByUsername(user.getUsername());
        if(dbUser!=null){
            //证明用户存在
            return  ResponseResult.error("用户已存在！！");
        }
        userMapper.addUser(user);
        if(user.getId()!=null){
            //证明用户增加成功
            return ResponseResult.success("用户增加成功！！！");
        }else{
            //证明用户增加失败
            return ResponseResult.error("用户增加失败！！！");
        }

    }

    @Override
    public ResponseResult delete(Integer id) {
        User dbUser = userMapper.findUserById(id);
        if(dbUser ==null){
            //证明用户存在
            return  ResponseResult.error("用户不存在！！");
        }
        int i = userMapper.deleteUser(id);
        if(i>0){
            //删除成功
            return ResponseResult.success("用户删除成功！！");
        }else{
            return ResponseResult.error("用户删除失败！！");
        }
    }

    @Override
    public ResponseResult resetpwd(Integer id) {
        //先查找到这个用户
        User user = userMapper.findUserById(id);
        if (user == null){
            return ResponseResult.error("用户不存在！！");
        }
        //修改密码
        int count = userMapper.resetpwd(id);
        if (count>0){
            //重置成功
            return ResponseResult.success("密码重置成功！！");
        }else{
            return ResponseResult.error("密码重置失败！！");
        }

    }

    @Override
    public ResponseResult get(Integer id) {
        User user = userMapper.findUserById(id);
        if (user==null){
            return ResponseResult.error("用户不存在！！");
        }else{
            return ResponseResult.success(user);
        }
    }

    @Override
    public Map all(Integer page, Integer size) {
        //设置分页的页数和条数
        PageHelper.startPage(page,size);
        List<User> userList = userMapper.findAll();
        PageInfo<User> info = new PageInfo<>(userList);
        long total = info.getTotal();
        List<User> list = info.getList();
        Map<String,Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",list);
        return map;
    }
}
