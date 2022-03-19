package com.example.demo.service.serviceImp;

import com.example.demo.bean.UserBean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest
//public class UserServiceImpTest extends AbstractTransactionalTestNGSpringContextTests {
public class UserServiceImpTest extends AbstractTestNGSpringContextTests {
    @Autowired
    UserServiceImp userServiceImp;
    @Test
    public void save(){
        UserBean s= userServiceImp.save(new UserBean(1,"root","root"));
        System.out.println(s);

    }

}