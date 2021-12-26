package com.daxu.picturesapp.Dao.impl;

import com.daxu.picturesapp.Dao.UserDao;
import com.daxu.picturesapp.Mapper.UserMapper;
import com.daxu.picturesapp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUser(User user) {
        try {
            User user1= userMapper.selectTheUser(user);
            return user1;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User insertUser(User user) {
        try {
            userMapper.insertTheUser(user);
            return userMapper.selectTheUser(user);
        } catch (Exception e) {
            return null;
        }
    }
}
