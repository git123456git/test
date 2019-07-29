package com.osyunge2.controller;

import com.osyunge.dataobject.EasyUIDataGridResult;
import com.osyunge.utils.FCResult;
import com.osyunge2.pojo.TbItem;

import com.osyunge2.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/{itemId}")
    @ResponseBody
    public TbItem selectItemInfoById(@PathVariable long itemId){
        return itemService.selectItemInfoById(itemId);
    }

    @GetMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(int page,int rows){
        return itemService.getItemList(page,rows);
    }


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public FCResult insertItem(TbItem item, String desc){
        FCResult result = itemService.insertItem(item,desc);
        return  result;
    }

}


