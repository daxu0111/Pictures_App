package com.daxu.picturesapp.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UploadMapper {
    @Insert("insert into pictures (url,picturename,username) values(#{url},#{picturename},#{username})")
    public void insertPic(String username,String url,String picturename);
}
