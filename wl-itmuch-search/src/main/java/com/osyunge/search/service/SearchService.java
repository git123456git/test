package com.osyunge.search.service;

import com.osyunge.dataobject.SearchResult;

public interface SearchService {
    SearchResult search(String queryString,int page,int rows) throws  Exception;
}
