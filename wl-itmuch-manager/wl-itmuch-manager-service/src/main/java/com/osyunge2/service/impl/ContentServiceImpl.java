package com.osyunge2.service.impl;

import com.osyunge.dataobject.EasyUIDataGridResult;
import com.osyunge2.mapper.TbContentMapper;
import com.osyunge2.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private TbContentMapper contentMapper;

    @Override
    public EasyUIDataGridResult getContentList(int page, int rows) {

        return null;
    }
}
