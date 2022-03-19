package com.example.demo.dao;

import com.example.demo.bean.UserBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
    //1、用于创建用户
    int saveUser(UserBean user);

    //2、用于删除用户
    int deleteUser(Long userId);

    //3、 用于更新用户
    int updateUser(UserBean user);

    //4、 通过ID查询用户
    UserBean getUserById(int userId);

    //5、 通过用户名和密码查询用户
    UserBean getUserByAccount(@Param("name") String name, @Param("password") String password);

    //6、 用于查询用户列表
    List<UserBean> getUserList(@Param("userCondition") UserBean user,
                               @Param("rowIndex") int rowIndex,
                               @Param("pageSize") int pageSize);

    //7、 用于查询用户列表数量
    int getUserBeanCount(@Param("UserBeanCondition") UserBean user);
}
