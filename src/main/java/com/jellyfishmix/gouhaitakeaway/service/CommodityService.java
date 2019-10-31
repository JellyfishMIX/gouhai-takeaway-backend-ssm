package com.jellyfishmix.gouhaitakeaway.service;

import com.jellyfishmix.gouhaitakeaway.entity.Commodity;

import java.util.List;

public interface CommodityService {
    /**
     * 列出菜单列表
     * @return commodityList
     */
    List<Commodity> getCommodityList();

    /**
     * 新增商品，返回值1为成功，-1为失败
     * @param commodity
     * @return int
     */
    int insertCommodity(Commodity commodity);

    /**
     * 修改商品
     * @param commodity
     * @return
     */
    int updateCommodity(Commodity commodity);

    /**
     * 删除商品
     * @param commodity
     * @return
     */
    int deleteCommodity(Commodity commodity);
}
