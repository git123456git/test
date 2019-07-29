package com.osyunge2.service.impl;

import com.osyunge.dataobject.EasyUITreeNode;
import com.osyunge2.mapper.TbContentCategoryMapper;
import com.osyunge2.pojo.TbContentCategory;
import com.osyunge2.pojo.TbContentCategoryExample;
import com.osyunge2.service.ContentCatgoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ContentCatgoryServiceImpl implements ContentCatgoryService {
    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;
    @Override
    public List<EasyUITreeNode> getContentCatgoryList(Long parentId) {
        //根据parentId查询子节点
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
        //转换成EasyUITreeNode 列表
        List<EasyUITreeNode> resultList= new ArrayList<>();
        for (TbContentCategory tbContentCategory:list){
            //创建一个 EasyUITreeNode 节点
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            node.setState(tbContentCategory.getIsParent()?"closed":"open");
            //添加列表
            resultList.add(node);
        }
        return resultList;
    }
}
