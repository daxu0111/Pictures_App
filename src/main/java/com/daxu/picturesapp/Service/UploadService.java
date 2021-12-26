package com.daxu.picturesapp.Service;

import com.daxu.picturesapp.domain.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadService {
    public Result uploadFile(MultipartFile zipFile, String username, String picturename) throws IOException;
}
