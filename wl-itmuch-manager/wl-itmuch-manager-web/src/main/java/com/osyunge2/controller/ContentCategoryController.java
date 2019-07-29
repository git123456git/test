package com.osyunge2.controller;

import com.osyunge.dataobject.EasyUITreeNode;
import com.osyunge2.service.ContentCatgoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
    @Autowired
    private ContentCatgoryService contentCatgoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getContenCatList(@RequestParam(value = "id",defaultValue = "0") Long parentId){
        List<EasyUITreeNode> list =contentCatgoryService.getContentCatgoryList(parentId);
        return list;
    }
}
