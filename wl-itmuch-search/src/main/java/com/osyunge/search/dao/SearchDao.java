package com.osyunge.search.dao;

import com.osyunge.dataobject.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;

public interface SearchDao {
    SearchResult search(SolrQuery query) throws Exception;
}
