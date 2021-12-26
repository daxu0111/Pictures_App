package com.daxu.picturesapp.Service.impl;

import com.daxu.picturesapp.Dao.UserDao;
import com.daxu.picturesapp.Dao.impl.UserDaoImpl;
import com.daxu.picturesapp.Service.UserService;
import com.daxu.picturesapp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User Login(User user) {
        return userDao.selectUser(user);
    }

    @Override
    public User Register(User user) {
        return userDao.insertUser(user);
    }
}
