package com.daxu.picturesapp.Dao.impl;

import com.daxu.picturesapp.Dao.UploadDao;
import com.daxu.picturesapp.Mapper.UploadMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UploadDaoImpl implements UploadDao {

    @Autowired
    private UploadMapper uploadMapper;
    private static final Logger logger = LoggerFactory.getLogger(UploadDao.class);

    @Override
    public void insertPic(String username, String url, String picturename) {
        try {
            uploadMapper.insertPic(username,url,picturename);
            logger.info("Insert the picture complete");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
