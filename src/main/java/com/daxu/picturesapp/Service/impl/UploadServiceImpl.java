package com.daxu.picturesapp.Service.impl;

import com.daxu.picturesapp.Dao.UploadDao;
import com.daxu.picturesapp.Dao.impl.UploadDaoImpl;
import com.daxu.picturesapp.Service.UploadService;
import com.daxu.picturesapp.domain.Result;
import com.daxu.picturesapp.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private UploadDao uploadDao;

    @Override
    public Result uploadFile(MultipartFile zipFile, String username, String picturename) throws IOException {

        //目标文件的保存路径
        String targetFilePath = "/www/text";
        String fileName = UUID.randomUUID().toString().replace("-","");
        String fileSuffix = getFileSuffix(zipFile);
        if (fileSuffix != null){    //拼接后缀
            fileName += fileSuffix;
        }
        File targetFile = new File(targetFilePath+File.separator+fileName);
        File file1 = new File(targetFilePath);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        //把图片存储到服务器中
        zipFile.transferTo(targetFile);
        String url="http://123.56.83.121:8084/source"+"/"+fileName;
        uploadDao.insertPic(username,url,picturename);
        System.out.println("File:"+fileName+" upload success");
        return ResultUtil.SuccessWithdata(null);
    }
    //获取文件的后缀
    private String getFileSuffix(MultipartFile file) {
        if (file == null) {
            return null;
        }
        String fileName = file.getOriginalFilename();
        int suffixIndex = fileName.lastIndexOf(".");
        if (suffixIndex == -1) {    // 无后缀
            return null;
        } else {                    // 存在后缀
            return fileName.substring(suffixIndex, fileName.length());
        }
    }
}
