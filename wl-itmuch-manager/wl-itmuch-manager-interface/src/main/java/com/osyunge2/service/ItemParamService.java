package com.osyunge2.service;

import com.osyunge.dataobject.EasyUITreeNode;

import java.util.List;

public interface ItemParamService {
    List<EasyUITreeNode> getItemParamList(Long parentId);
}
