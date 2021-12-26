package com.daxu.picturesapp.Mapper;

import com.daxu.picturesapp.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user where username=#{username} and password=#{password}")
    public User selectTheUser(User user);

    @Insert("insert into user (username,password) values(#{username},#{password})")
    public void insertTheUser(User user);
}
