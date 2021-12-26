package com.daxu.picturesapp.Controller;

import com.daxu.picturesapp.Service.UploadService;
import com.daxu.picturesapp.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UploadController {
    @Autowired
    private UploadService uploadService;
    @RequestMapping("/upload")
    public Result Upload(@RequestParam("uploadFile") MultipartFile zipFile, String username, String picturename) throws IOException {
        return uploadService.uploadFile(zipFile,username,picturename);
    }
}
