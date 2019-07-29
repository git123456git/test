package com.osyunge2.service;

import com.osyunge.dataobject.EasyUIDataGridResult;
import com.osyunge.utils.FCResult;
import com.osyunge2.pojo.TbItem;


public interface ItemService {
    //根据商品 id查询商品信息
    TbItem selectItemInfoById(long itemid);
    //查询商品信息列表
    EasyUIDataGridResult getItemList(int page,int rows);

    //添加商品
    FCResult insertItem(TbItem item,String desc);
    //更新商品信息
    //FCResult updateByItem();
}
