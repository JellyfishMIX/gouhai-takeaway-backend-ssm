package com.jellyfishmix.gouhaitakeaway.dao;

import com.jellyfishmix.gouhaitakeaway.entity.Order;
import com.jellyfishmix.gouhaitakeaway.entity.OrderCommodity;

import java.util.List;

public interface OrderCommodityDao {
    /**
     * 批量添加订单商品
     * @param orderCommodityList
     * @return
     */
    int batchInsertOrderCommodity(List<OrderCommodity> orderCommodityList);

    /**
     * 删除orderId对应的orderCommodity
     * @param order
     * @return
     */
    int deleteOrderCommodity(Order order);
}
