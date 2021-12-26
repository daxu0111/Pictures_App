package com.daxu.picturesapp.Dao;

import com.daxu.picturesapp.domain.User;

public interface UserDao {
    public User selectUser(User user);
    public User insertUser(User user);
}
