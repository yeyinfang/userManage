package com.ye.mapper;

import com.ye.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RoleMapper {
    /** 
    * @Description: 根据名字找到角色
    * @Param: [roleName] 
    * @return: com.ye.pojo.Role 
    * @Author: Yin 
    * @Date: 2018/7/3 
    */ 
    Role findRoleByName(String roleName);

    /** 
    * @Description: 增加角色
    * @Param: [role] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/7/3 
    */ 
    void addRole(Role role);

    /** 
    * @Description: 根据id查找到角色
    * @Param: [id] 
    * @return: com.ye.pojo.Role 
    * @Author: Yin 
    * @Date: 2018/7/3 
    */ 
    Role findRoleById(Integer id);

    /** 
    * @Description: 删除用户
    * @Param: [id] 
    * @return: int 
    * @Author: Yin 
    * @Date: 2018/7/3 
    */ 
    int deleteRole(Integer id);

    /** 
    * @Description: 根据id修改用户
    * @Param: [id] 
    * @return: int 
    * @Author: Yin 
    * @Date: 2018/7/3
     * @param id
    */ 
    int updateRole(Role id);

    /** 
    * @Description: 查找所有的 
    * @Param: [] 
    * @return: java.util.List<com.ye.pojo.Role> 
    * @Author: Yin 
    * @Date: 2018/7/3 
    */ 
    List<Role> findAll();

    /** 
    * @Description: 绑定权限
    * @Param: [i] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/7/4 
    */ 
    int addPerm(@Param("roleId") Integer roleId, @Param("permIds") String[] permIds);



    /** 
    * @Description: 所有的权限都删除
    * @Param: [id] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/7/4 
    */ 
    void deletePerm(Integer id);

    /** 
    * @Description: 查找自己的权限
    * @Param: [id] 
    * @return: java.util.List<com.ye.pojo.Role> 
    * @Author: Yin 
    * @Date: 2018/7/4 
    */ 
    List<Role> findPerm(Integer id);

    /** 
    * @Description: 查找到角色的shuju
    * @Param: [id] 
    * @return: java.util.List<com.ye.pojo.Role> 
    * @Author: Yin 
    * @Date: 2018/7/4 
    */ 
    List<Role> findRole(Integer id);
}
