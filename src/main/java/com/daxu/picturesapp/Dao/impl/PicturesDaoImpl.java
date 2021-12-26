package com.daxu.picturesapp.Dao.impl;

import com.daxu.picturesapp.Dao.PicturesDao;
import com.daxu.picturesapp.Mapper.PicturesMapper;
import com.daxu.picturesapp.domain.Pictures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PicturesDaoImpl implements PicturesDao {

    @Autowired
    private PicturesMapper picturesMapper;

    @Override
    public List<Pictures> selectAllPictures() {
        try {
            return picturesMapper.sellectAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String selectUrlById(int id) {
        try {
            return picturesMapper.selectUrlById(id);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void updateLiked(int id, int count) {
        try {
            picturesMapper.updateLiked(id,count);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int selectLikedById(int id) {
        try {
            return picturesMapper.selectLikedById(id);
        }catch (Exception e){
            return -1;
        }
    }

    @Override
    public List<Integer> selectIsLikedByUsername(String username) {
        return null;
    }

    @Override
    public void insertIntoLiked(String username, int pid) {
        try{
            picturesMapper.insertIntoLiked(username,pid);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFromLiked(String username, int pid) {
        try{
            picturesMapper.deleteFromLiked(username,pid);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
