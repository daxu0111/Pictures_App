package com.daxu.picturesapp.Mapper;

import com.daxu.picturesapp.domain.Pictures;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PicturesMapper {

    @Select("select * from pictures order by pid desc")
    public List<Pictures> sellectAll();
    @Select("select url from pictures where pid=#{id}")
    public String selectUrlById(int id);
    @Select("select liked from pictures where pid=#{id}")
    public int selectLikedById(int id);
    @Update("update pictures set liked=#{count} where  pid=#{id}")
    public void updateLiked(int id,int count);
    @Select("select pid from liked where username=#{username}")
    public List<Integer> selectIsLikedByUsername(String username);
    @Insert("insert into liked (username,pid) values (#{username},#{pid})")
    public void insertIntoLiked(String username,int pid);
    @Delete("delete from liked where username=#{username} and pid=#{pid}")
    public void deleteFromLiked(String username,int pid);
}
