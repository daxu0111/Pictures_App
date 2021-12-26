package com.daxu.picturesapp.Controller;

import com.daxu.picturesapp.Service.UserService;
import com.daxu.picturesapp.Service.impl.UserServiceImpl;
import com.daxu.picturesapp.domain.Result;
import com.daxu.picturesapp.domain.User;
import com.daxu.picturesapp.util.RedisUtil;
import com.daxu.picturesapp.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;


@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Resource
    private RedisUtil redisUtil;
    @RequestMapping("/login")
    public Result Login(String username,String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User userResponse=userService.Login(user);
        if(userResponse!=null)
        {
            String token = UUID.randomUUID().toString().replaceAll("-","");
            redisUtil.setex(username,token,7*24*60*60);
            logger.info(username+"'s token save success.........");
            return ResultUtil.SuccessWithtoken(user,token);
        }
        else
        {
            return ResultUtil.fail("failed");
        }
    }
    @RequestMapping("/register")
    public Result Register(String username,String password)
    {
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        User UserResponse=userService.Register(user);
        if(UserResponse!=null)
        {
            logger.info(UserResponse.getUsername()+" register success");
            return ResultUtil.SuccessWithdata(UserResponse);
        }
        else
        {
            return ResultUtil.fail("failed");
        }
    }
}
