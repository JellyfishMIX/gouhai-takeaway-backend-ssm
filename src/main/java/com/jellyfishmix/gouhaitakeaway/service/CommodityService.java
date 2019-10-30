package com.jellyfishmix.gouhaitakeaway.service;

import com.jellyfishmix.gouhaitakeaway.entity.Commodity;

import java.util.List;

public interface CommodityService {
    /**
     * 列出菜单列表
     * @return commodityList
     */
    List<Commodity> getCommodityList();
}
