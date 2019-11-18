package com.jellyfishmix.gouhaitakeaway.service;

import com.jellyfishmix.gouhaitakeaway.dto.OrderExecution;
import com.jellyfishmix.gouhaitakeaway.entity.Order;

public interface OrderService {
    /**
     *
     * @param order
     * @return
     */
    OrderExecution addOrder(Order order);
}
