package com.osyunge.rest.service.impl;


import com.osyunge.rest.service.ItemService;
import com.osyunge.utils.FCResult;
import com.osyunge2.mapper.TbItemMapper;
import com.osyunge2.pojo.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public  class ItemServiceImpl implements ItemService {

    @Autowired
    public TbItemMapper itemMapper;

    @Value("${REDIS_ITEM_KEY}")
    private  String REDIS_ITEM_KEY;
    @Value("${REDIS_ITEM_EXPIRE}")
    private Integer REDIS_ITEM_EXPIRE;

    @Autowired


    @Override
    public FCResult getBaseItemInfo(long itemId) {
        //根据商品id查询商品信息
        TbItem item = itemMapper.selectByPrimaryKey(itemId);
        // 使用 FCResult  包装一下

        return FCResult.ok(item);
    }

    @Override
    public FCResult getItemDesc(long itemId) {

        //创建查询条件
        TbItem itemDesc = itemMapper.selectByPrimaryKey(itemId);

        return FCResult.ok(itemDesc);
    }
}