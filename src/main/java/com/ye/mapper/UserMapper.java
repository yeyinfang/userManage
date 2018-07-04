package com.ye.mapper;

import com.ye.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /** 
    * @Description: 增加用户 
    * @Param: [user] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/7/3 
    */ 
    void addUser(User user);

    /** 
    * @Description:  跟据名字去查找用户
    * @Param: [username]
    * @return: com.ye.pojo.User 
    * @Author: Yin 
    * @Date: 2018/7/3 
     * @param username
    */ 
    User findUserByUsername(String username);

    /** 
    * @Description: 删除用户
    * @Param: [id] 
    * @return: int 
    * @Author: Yin 
    * @Date: 2018/7/3 
    */ 
    int deleteUser(Integer id);

    /** 
    * @Description: 根据id的查询用户
    * @Param: [id] 
    * @return: com.ye.pojo.User 
    * @Author: Yin 
    * @Date: 2018/7/3 
    */ 
    User findUserById(Integer id);

    /** 
    * @Description: 根据用户id去修改密码 
    * @Param: [id] 
    * @return: int 
    * @Author: Yin 
    * @Date: 2018/7/3 
    */
    int resetpwd(Integer id);

    /** 
    * @Description: 查找到所有 
    * @Param: [] 
    * @return: java.util.List<com.ye.pojo.User> 
    * @Author: Yin 
    * @Date: 2018/7/3 
    */ 
    List<User> findAll();

    /** 
    * @Description: 删除所有的角色根据id
    * @Param: [id] 
    * @return: void 
    * @Author: Yin 
    * @Date: 2018/7/4 
    */ 
    void deleteRole(Integer id);

    /** 
    * @Description: 添加用户的角色
    * @Param: [id, ids] 
    * @return: int 
    * @Author: Yin 
    * @Date: 2018/7/4 
    */ 
    int addRoles(@Param("id") Integer id,@Param("ids") String[] ids);
}
