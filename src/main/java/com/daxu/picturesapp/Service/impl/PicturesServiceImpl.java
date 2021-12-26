package com.daxu.picturesapp.Service.impl;

import com.daxu.picturesapp.Dao.PicturesDao;
import com.daxu.picturesapp.Dao.impl.PicturesDaoImpl;
import com.daxu.picturesapp.Service.PicturesService;
import com.daxu.picturesapp.domain.Pictures;
import com.daxu.picturesapp.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PicturesServiceImpl implements PicturesService {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private PicturesDao picturesDao;

    @Override
    public List<Pictures> showAllPictures(String token, String username) {
        String ctoken=redisUtil.get(username);
        if(token==null||ctoken==null||ctoken.length()!=token.length()){
            return null;
        }
        for (int i = 0; i < token.length(); i++) {
             if(token.charAt(i)!=ctoken.charAt(i)){
                 return null;
             }
        }
        List<Pictures> picturesList = picturesDao.selectAllPictures();
        List<Integer> liked_ids = picturesDao.selectIsLikedByUsername(username);
        System.out.println(picturesList);
        if (picturesList==null){
            return null;
        }
        if (liked_ids==null){
            return picturesList;
        }
        Set<Integer> set = new HashSet<Integer>(liked_ids);
        for (Pictures pictures : picturesList) {
            if (set.contains(pictures.getPid())){
                pictures.setCollect(true);
            } else {
                pictures.setCollect(false);
            }
        }
        return picturesList;
    }

    @Override
    public String searchUrl(int id, String token, String username) {
        String ctoken = redisUtil.get(username);
        if(token==null||ctoken==null||ctoken.length()!=token.length()){
            return null;
        }
        for (int i = 0; i < token.length(); i++) {
            if(token.charAt(i)!=ctoken.charAt(i)){
                return null;
            }
        }
        return picturesDao.selectUrlById(id);
    }

    @Override
    public int addLiked(int id, String username, String token) {
        String ctoken = redisUtil.get(username);
        if(token==null||ctoken==null||ctoken.length()!=token.length()){
            return -2;
        }
        for (int i = 0; i < token.length(); i++) {
            if(token.charAt(i)!=ctoken.charAt(i)){
                return -2;
            }
        }
        List<Integer> likedList = picturesDao.selectIsLikedByUsername(username);
        Set<Integer> set = new HashSet<Integer>(likedList);
        if(set.contains(id)){
            return -1;
        }
        int current_count = picturesDao.selectLikedById(id);
        current_count++;
        picturesDao.updateLiked(id,current_count);
        picturesDao.insertIntoLiked(username,id);
        return current_count;
    }

    @Override
    public int subLiked(int id, String username, String token) {
        String ctoken = redisUtil.get(username);
        if(token==null||ctoken==null||ctoken.length()!=token.length()){
            return -2;
        }
        for (int i = 0; i < token.length(); i++) {
            if(token.charAt(i)!=ctoken.charAt(i)){
                return -2;
            }
        }
        List<Integer> likedList = picturesDao.selectIsLikedByUsername(username);
        Set<Integer> set = new HashSet<Integer>(likedList);
        if (!set.contains(id)){
            return -1;
        }
        int current_count = picturesDao.selectLikedById(id);
        if(current_count==0){
            return -1;
        }
        current_count--;
        picturesDao.updateLiked(id,current_count);
        picturesDao.deleteFromLiked(username,id);
        return current_count;
    }
}
