package com.daxu.picturesapp.Service;

import com.daxu.picturesapp.domain.Pictures;

import java.util.List;

public interface PicturesService {
    public List<Pictures> showAllPictures(String token, String username);
    public String searchUrl(int id,String token,String username);
    public int addLiked(int id,String username,String token);
    public int subLiked(int id,String username,String token);
}
