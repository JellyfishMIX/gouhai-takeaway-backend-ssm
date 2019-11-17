package com.jellyfishmix.gouhaitakeaway.dao;

import com.jellyfishmix.gouhaitakeaway.entity.Order;

public interface OrderDao {
    /**
     * 新增订单
     * @param order
     * @return
     */
    int insertOrder(Order order);
}
