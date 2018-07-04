package com.ye.mapper;

import com.ye.pojo.Permission;

import java.util.List;

/**
 * @program: maven-ssm
 * @description:
 * @author: YF
 * @create: 2018-07-03 23:55
 **/
public interface PermissionMapper {
    /** 
    * @Description: 根据名字找到权限 
    * @Param: [permName] 
    * @return: com.ye.pojo.Permission 
    * @Author: Yin 
    * @Date: 2018/7/4 
    */ 
    Permission findPermByName(String permName);

    /** 
    * @Description: 添加权限 
    * @Param: [permission] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/7/4 
    */ 
    void addPerm(Permission permission);

    /** 
    * @Description: 根据id查找到权限
    * @Param: [id] 
    * @return: com.ye.pojo.Permission 
    * @Author: Yin 
    * @Date: 2018/7/4 
    */ 
    Permission findPermById(Integer id);

    /** 
    * @Description: 删除权限
    * @Param: [id] 
    * @return: int 
    * @Author: Yin 
    * @Date: 2018/7/4 
    */ 
    int deletePerm(Integer id);

    /** 
    * @Description: 更新权限
    * @Param: [permission] 
    * @return: int 
    * @Author: Yin 
    * @Date: 2018/7/4 
    */ 
    int updatePerm(Permission permission);

    /** 
    * @Description: 查找所有
    * @Param: [] 
    * @return: java.util.List<com.ye.pojo.Permission> 
    * @Author: Yin 
    * @Date: 2018/7/4 
    */ 
    List<Permission> findAll();
}
