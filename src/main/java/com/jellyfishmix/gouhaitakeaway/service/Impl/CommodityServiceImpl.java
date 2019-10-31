package com.jellyfishmix.gouhaitakeaway.service.Impl;

import com.jellyfishmix.gouhaitakeaway.dao.CommodityDao;
import com.jellyfishmix.gouhaitakeaway.entity.Commodity;
import com.jellyfishmix.gouhaitakeaway.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityDao commodityDao;

    /**
     * 列出菜单列表
     * @return commodityList
     */
    @Override
    public List<Commodity> getCommodityList() {
        return commodityDao.queryCommodityList();
    };

    /**
     * 新增商品，返回值1为成功，-1为失败
     * @param commodity
     * @return int
     */
    @Override
    public int insertCommodity(Commodity commodity) {
        return commodityDao.insertCommodity(commodity);
    }

    /**
     * 修改商品
     * @param commodity
     * @return
     */
    @Override
    public int updateCommodity(Commodity commodity) {
        return commodityDao.updateCommodity(commodity);
    }

    /**
     * 删除商品
     * @param commodity
     * @return
     */
    @Override
    public int deleteCommodity(Commodity commodity) {
        return commodityDao.deleteCommodity(commodity);
    }
}
