package com.jellyfishmix.gouhaitakeaway.service;

import com.jellyfishmix.gouhaitakeaway.dto.CommodityExecution;
import com.jellyfishmix.gouhaitakeaway.dto.ImageHolder;
import com.jellyfishmix.gouhaitakeaway.entity.Commodity;

import java.util.List;

public interface CommodityService {
    /**
     * 列出菜单列表
     * @return commodityList
     */
    List<Commodity> getCommodityList();

    /**
     * 添加商品
     * @param commodity
     * @param thumbnail
     * @return int
     */
    CommodityExecution addCommodity(Commodity commodity, ImageHolder thumbnail);

    /**
     * 修改商品
     * @param commodity
     * @return
     */
    CommodityExecution updateCommodity(Commodity commodity);

    /**
     * 删除商品
     * @param commodity
     * @return
     */
    CommodityExecution deleteCommodity(Commodity commodity);
}
