package com.osyunge.search.controller;

import com.osyunge.search.service.ItemService;
import com.osyunge.utils.FCResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manager")
public class ItemController {
    @Autowired
    private ItemService itemService;

    /**
     * 导入商品数据到索引库
     */
    @RequestMapping("/impoart/all")
    @ResponseBody
    /*public FCResult ImportAllItem(){
        FCResult result = itemService.getItemList();
        return  result;
    } */

    public MappingJacksonValue getImportAll(String callback){
        FCResult result = itemService.getItemList();
        MappingJacksonValue jsonValue = new MappingJacksonValue(result);
        jsonValue.setJsonpFunction(callback);
        return jsonValue;
    }

}
