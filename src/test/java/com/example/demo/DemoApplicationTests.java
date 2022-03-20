package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Wrapper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        user.setId(7L);
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
        user.setId(7L);
        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("id",user.getId());
        queryWrapper.equals(user.getId());
        userMapper.updateById(user);
    }
    @Test
    public void updateTest2(){
        QueryWrapper queryWrapper =new QueryWrapper();
        queryWrapper.eq("id",9);
        User user =userMapper.selectOne(queryWrapper);
        user.setName("zlj9");
        userMapper.updateById(user);
    }
    @Test
    public void selectTest1(){
        //根据id批量查询
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        //根据id查询
        User user = userMapper.selectById("1L");
        //根据map查询
        Map<String, Object> map = new HashMap<>();
        map.put("id",1);
        List<User> users1 = userMapper.selectByMap(map);
        //根据queryWrapper查询
        QueryWrapper queryWrapper =new QueryWrapper();
        queryWrapper.eq("id","9");
        User user2 =userMapper.selectOne(queryWrapper);
        users1.forEach(System.out::println);
        System.out.println(user);
        users.forEach(System.out::println);
    }
    @Test
    public void pageTest(){
        //高版本的mybatis,selectMapsPage传入的需要是ipage而不是page了
        Page<User> page2=new Page<>(1,5);
        QueryWrapper<User> query=new QueryWrapper<>();
        query.orderByDesc("id");
        IPage ipage = new Page<>(1, 5);
        IPage iPage = userMapper.selectMapsPage(ipage, query);
        iPage.getRecords().forEach(System.out::println);
        userMapper.selectPage(page2,query);
        page2.getRecords().forEach(System.out::println);
        System.out.println(ipage.getCurrent());
        System.out.println(ipage.getPages());
        System.out.println(ipage.getSize());
        System.out.println(ipage.getTotal());
        System.out.println(((Page)ipage).hasNext());
        System.out.println(((Page)ipage).hasPrevious());
    }
    @Test
    public void deleteTest(){
        //根据id删除
        userMapper.deleteById(7L);
//        //根据id批量删除
//        userMapper.deleteBatchIds(Arrays.asList(1,2,3));
//        //查询后删除
//        QueryWrapper query=new QueryWrapper();
//        query.eq("id",5);
//        userMapper.delete(query);
    }




}
