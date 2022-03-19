package com.example.demo.service.serviceImp;

import com.example.demo.bean.UserBean;
import com.example.demo.dao.UserDao;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public UserBean save(UserBean user) {
        userDao.saveUser(user);
        return userDao.getUserById(user.getId());
    }
}
