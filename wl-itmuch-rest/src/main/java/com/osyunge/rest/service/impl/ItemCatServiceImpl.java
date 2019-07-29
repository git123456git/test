package com.osyunge.rest.service.impl;


import com.osyunge.dataobject.CatNode;
import com.osyunge.dataobject.ItemCatResult;
import com.osyunge.rest.service.ItemCatService;
import com.osyunge2.mapper.TbItemCatMapper;


import com.osyunge2.pojo.TbItemCat;
import com.osyunge2.pojo.TbItemCatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public ItemCatResult getItemCatList() {
        //调用递归方法查询商品分类列表
        List catList = getItemCatList(0l);
        System.out.println("catList:"+catList);
        //返回结果
        ItemCatResult result = new ItemCatResult();
        result.setData(catList);
        System.out.println("result:"+result);
          return result;
    }

    public List getItemCatList(Long parentId){
        //根据parentId 查询列表
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria =example.createCriteria();
        System.out.println("criteria:"+criteria);
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        List resultList = new ArrayList();
        for (TbItemCat tbItemCat:list){
            //如果是父节点
            if (tbItemCat.getIsParent()){
                CatNode node = new CatNode();
                node.setUrl("/products/"+tbItemCat.getId()+".html");
                //如果当前节点为一级节点
                if (tbItemCat.getParentId()==0){
                    node.setName("<a href='/products/"+tbItemCat.getId() + ".html'>"+tbItemCat.getName()+"</a>");
                }else{
                    node.setName(tbItemCat.getName());
                }
                node.setItems(getItemCatList(tbItemCat.getId()));
                System.out.println("node:"+node);
                //把node添加到列表
                resultList.add(node);
            }else{
                //如果是叶子节点
                String item = "/products/" + tbItemCat.getId() + ".html|" + tbItemCat.getName();
                resultList.add(item);
            }
        }
        return resultList;
    }
}
