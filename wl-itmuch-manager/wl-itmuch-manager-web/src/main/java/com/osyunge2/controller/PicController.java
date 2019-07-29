package com.osyunge2.controller;

import com.osyunge.dataobject.PicResult;
import com.osyunge2.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PicController {
    @Autowired
    private PicService picService;
    @RequestMapping("/pic/upload")
    @ResponseBody
    public PicResult uploadFile(MultipartFile uploadFile){
        PicResult result = picService.uploadFile(uploadFile);
        return  result;
    }
}
