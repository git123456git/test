package com.osyunge.portal.service.impl;

import com.osyunge.dataobject.SearchResult;
import com.osyunge.portal.service.SearchService;
import com.osyunge.utils.FCResult;
import com.osyunge.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    @Value("${SEARCH_BASE_UR}")  //调用Search 服务       url  search 模块的url
    private String SEARCH_BASE_UR;

    @Override
    public SearchResult search(String queryString, int page) {
        //调用 search 的服务
        //查询参数
        Map<String,String> param = new HashMap<>();
        param.put("q",queryString);
        param.put("page",page+"");
        try{
            //调用服务
            String json = HttpClientUtil.doGet(SEARCH_BASE_UR,param);
            //把字符串转换成 java 对象
            FCResult fcResult =FCResult.formatToPojo(json,SearchResult.class);
            if (fcResult.getStatus() == 200){
                SearchResult result = (SearchResult) fcResult.getData();
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
