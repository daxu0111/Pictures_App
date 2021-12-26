package com.daxu.picturesapp.Dao;

import com.daxu.picturesapp.domain.Pictures;

import java.util.List;

public interface PicturesDao {
    public List<Pictures> selectAllPictures();
    public String selectUrlById(int id);
    public void updateLiked(int id,int count);
    public int selectLikedById(int id);
    public List<Integer> selectIsLikedByUsername(String username);
    public void insertIntoLiked(String username,int pid);
    public void deleteFromLiked(String username,int pid);
}
