package com.jellyfishmix.gouhaitakeaway.service.Impl;

import com.jellyfishmix.gouhaitakeaway.dao.OrderCommodityDao;
import com.jellyfishmix.gouhaitakeaway.dao.OrderDao;
import com.jellyfishmix.gouhaitakeaway.dto.OrderExecution;
import com.jellyfishmix.gouhaitakeaway.entity.Order;
import com.jellyfishmix.gouhaitakeaway.entity.OrderCommodity;
import com.jellyfishmix.gouhaitakeaway.enums.OrderStateEnum;
import com.jellyfishmix.gouhaitakeaway.exceptions.OrderOperationException;
import com.jellyfishmix.gouhaitakeaway.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderCommodityDao orderCommodityDao;

    /**
     * 新增订单
     * @param order
     * @return
     */
    @Override
    // 新增订单，并将订单中的商品列表批量添加进数据库
    public OrderExecution addOrder(Order order) {
        if (order != null) {
            try {
                int effectedNum1 = orderDao.insertOrder(order);
                if (effectedNum1 <= 0) {
                    throw new OrderOperationException("添加订单失败");
                }
                for (OrderCommodity orderCommodity : order.getOrderCommodityList()) {
                    orderCommodity.setOrderId(order.getOrderId());
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

    public OrderExecution modifyOrderToArrived(Order order) {
        if (order != null) {
            order.setArrived(true);
            int effectedNum = orderDao.updateOrder(order);
            if (effectedNum <= 0) {
                throw new OrderOperationException("更新订单状态为已送达失败");
            }
            return new OrderExecution(OrderStateEnum.SUCCESS);
        } else {
            return new OrderExecution(OrderStateEnum.EMPTY);
        }
    }

    /**
     * 获取订单列表
     * @return
     */
    @Override
    public List<Order> getOrderList() {
        List<Order> orderList = orderDao.queryOrderList();
        if (orderList != null && orderList.size() > 0) {
            return orderList;
        } else {
            throw new OrderOperationException("获取订单列表失败");
        }
    }
}
