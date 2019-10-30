package com.jellyfishmix.gouhaitakeaway.dao;

import com.jellyfishmix.gouhaitakeaway.entity.Commodity;

import java.util.List;

public interface CommodityDao {
    /**
     * 列出菜单列表
     * @return commodityList
     */
    List<Commodity> queryCommodityList();
}
