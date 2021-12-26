package com.daxu.picturesapp.Service;

import com.daxu.picturesapp.domain.User;

public interface UserService {
    public User Login(User user);
    public User Register(User user);
}
