package com.osyunge2.service;

import com.osyunge.dataobject.EasyUIDataGridResult;
import com.osyunge.dataobject.EasyUITreeNode;

public interface ContentService {
    EasyUIDataGridResult getContentList(int page,int rows);
}
