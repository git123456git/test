package com.osyunge.rest.service;

import com.osyunge.utils.FCResult;

public interface ItemService {
    FCResult getBaseItemInfo(long itemId);
    FCResult getItemDesc(long itemId);
}
