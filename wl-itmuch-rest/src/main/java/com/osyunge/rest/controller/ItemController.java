package com.osyunge.rest.controller;

import com.osyunge.rest.service.ItemService;
import com.osyunge.utils.FCResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @RequestMapping("/info/{itemId}")
    @ResponseBody
    public FCResult getItemBaseInfo(@PathVariable long itemId){
        FCResult result = itemService.getBaseItemInfo(itemId);
        return result;
    }

    @RequestMapping("/desc/{itemId}")
    @ResponseBody
    public FCResult getItemDesc(@PathVariable Long itemId){
        FCResult resultDesc = itemService.getItemDesc(itemId);
        return resultDesc;
    }

}
