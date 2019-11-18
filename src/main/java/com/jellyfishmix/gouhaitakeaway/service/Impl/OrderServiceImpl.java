package com.jellyfishmix.gouhaitakeaway.service.Impl;

import com.jellyfishmix.gouhaitakeaway.dao.OrderCommodityDao;
import com.jellyfishmix.gouhaitakeaway.dao.OrderDao;
import com.jellyfishmix.gouhaitakeaway.dto.OrderExecution;
import com.jellyfishmix.gouhaitakeaway.entity.Order;
import com.jellyfishmix.gouhaitakeaway.enums.OrderStateEnum;
import com.jellyfishmix.gouhaitakeaway.exceptions.OrderOperationException;
import com.jellyfishmix.gouhaitakeaway.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderCommodityDao orderCommodityDao;

    // 新增订单，并将订单中的商品列表批量添加进数据库
    public OrderExecution addOrder(Order order) {
        if (order != null) {
            try {
                int effectedNum1 = orderDao.insertOrder(order);
                if (effectedNum1 <= 0) {
                    throw new OrderOperationException("添加订单失败");
                }
                int effectedNum2 = orderCommodityDao.batchInsertOrderCommodity(order.getOrderCommodityList());
                if (effectedNum2 <= 0) {
                    throw new OrderOperationException("添加订单的商品列表失败");
                }
            } catch (Exception e) {
                throw new OrderOperationException("添加订单失败，errMsg: " + e.toString());
            }
            return new OrderExecution(OrderStateEnum.SUCCESS);
        } else {
            return new OrderExecution(OrderStateEnum.EMPTY);
        }
    }
}
