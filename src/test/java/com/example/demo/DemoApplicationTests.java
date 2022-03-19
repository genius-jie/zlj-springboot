package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Wrapper;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void userBeanTest() {
        List<User> userBeans = userMapper.selectList(null);
        System.out.println(userBeans);
    }
    @Test
    public void insertTest(){
        User user=new User();
        user.setAge(19);
        user.setEmail("547148204.com");
        user.setName("zlj2");
        userMapper.insert(user);
    }
    @Test
    public void updateTest(){
        User user=new User();
        user.setAge(19);
        user.setEmail("547148204.com");
        user.setName("zlj1");
        user.setId(9L);
        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("id",user.getId());
        queryWrapper.equals(user.getId());
        userMapper.updateById(user);
    }
    @Test
    public void updateTest2(){
        QueryWrapper queryWrapper =new QueryWrapper();
        queryWrapper.eq("id","9");
        User user =userMapper.selectOne(queryWrapper);
        user.setName("zlj9");
        userMapper.updateById(user);
    }


}
