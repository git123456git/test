package com.osyunge2.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.osyunge.dataobject.EasyUIDataGridResult;
import com.osyunge.utils.FCResult;
import com.osyunge.utils.IDUtils;
import com.osyunge2.mapper.TbItemDescMapper;
import com.osyunge2.mapper.TbItemMapper;
import com.osyunge2.pojo.TbItem;
import com.osyunge2.pojo.TbItemDesc;
import com.osyunge2.pojo.TbItemExample;
import com.osyunge2.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;
    @Autowired
    private TbItemDescMapper itemDescMapper;
    @Override
    public TbItem selectItemInfoById(long itemid) {
        //创建example 对象  创建criteria 对象（设置查询条件）
        TbItemExample itemExample = new TbItemExample();
        TbItemExample.Criteria criteria = itemExample.createCriteria();
        //设置条件
        criteria.andIdEqualTo(itemid);
        //执行查询
        List<TbItem> tbItems= itemMapper.selectByExample(itemExample);
        TbItem item=null;
        if (tbItems.size()>0){
            item=tbItems.get(0);
        }
        return item;
    }

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
        //设置分页信息
        PageHelper.startPage(page,rows);
        List<TbItem> itemList = itemMapper.selectByExample(new TbItemExample());
        PageInfo<TbItem> info = new PageInfo<>(itemList);
        //取分页信息
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(itemList);
        result.setTotal(info.getTotal());
        return result;
    }

    @Override
    public FCResult insertItem(TbItem item, String desc) {
        //生成商品id
        Long itemId= IDUtils.genItemId();
        //补全Tbtem属性
        item.setId(itemId);
        //商品状态 1-正常，2-下架，3-删除
        item.setStatus((byte) 1);
        //创建时间和更新时间
        Date date = new Date();
        item.setCreated(date);
        item.setUpdated(date);
        //插入商品表
        itemMapper.insert(item);
        //商品描述
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(date);
        itemDesc.setUpdated(date);
        //插入商品描述数据
        itemDescMapper.insert(itemDesc);
        return FCResult.ok();
    }



}

