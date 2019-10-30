package com.jellyfishmix.gouhaitakeaway.dao;

import com.jellyfishmix.gouhaitakeaway.entity.Commodity;

import java.util.List;

public interface CommodityDao {
    /**
     * 列出菜单列表
     * @return commodityList
     */
    List<Commodity> queryCommodityList();

    /**
     * 新增商品，返回值1为成功，-1为失败
     * @param commodity
     * @return
     */
    int insertCommodity(Commodity commodity);

    /**
     * 修改商品
     * @param commodity
     * @return
     */
    int updateCommodity(Commodity commodity);
}
