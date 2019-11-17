package com.jellyfishmix.gouhaitakeaway.dao;

import com.jellyfishmix.gouhaitakeaway.entity.OrderCommodity;

import java.util.List;

public interface OrderCommodityDao {
    int batchInsertOrderCommodity(List<OrderCommodity> orderCommodityList);
}
