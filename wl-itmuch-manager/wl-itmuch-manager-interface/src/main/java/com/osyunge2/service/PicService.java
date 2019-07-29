package com.osyunge2.service;

import com.osyunge.dataobject.PicResult;
import org.springframework.web.multipart.MultipartFile;

public interface PicService {
    PicResult uploadFile(MultipartFile picFile);
}
