package com.jellyfishmix.gouhaitakeaway.dao;

import com.jellyfishmix.gouhaitakeaway.entity.Order;

import java.util.List;

public interface OrderDao {
    /**
     * 新增订单
     * @param order
     * @return
     */
    int insertOrder(Order order);

    /**
     * 删除订单
     * @param order
     * @return
     */
    int deleteOrder(Order order);

    /**
     * 修改订单
     * @param order
     * @return
     */
    int updateOrder(Order order);

    /**
     * 列出订单列表
     */
    List<Order> queryOrderList();
}
