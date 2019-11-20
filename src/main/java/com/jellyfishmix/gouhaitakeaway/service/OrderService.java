package com.jellyfishmix.gouhaitakeaway.service;

import com.jellyfishmix.gouhaitakeaway.dto.OrderExecution;
import com.jellyfishmix.gouhaitakeaway.entity.Order;

import java.util.List;

public interface OrderService {
    /**
     * 新增订单
     * @param order
     * @return
     */
    OrderExecution addOrder(Order order);

    /**
     * 获取订单列表
     * @return
     */
    List<Order> getOrderList();
}
