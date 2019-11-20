package com.jellyfishmix.gouhaitakeaway.service;

import com.jellyfishmix.gouhaitakeaway.BaseTest;
import com.jellyfishmix.gouhaitakeaway.dto.OrderExecution;
import com.jellyfishmix.gouhaitakeaway.entity.Order;
import com.jellyfishmix.gouhaitakeaway.entity.OrderCommodity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceTest extends BaseTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void testAddOrder() {
        Order order = new Order();
        order.setCustomerName("唐马儒");
        order.setCustomerPhone(13315766783L);
        order.setCustomerAddr("河北农业大学渤海校区");
        order.setTotalPrice(23);

        OrderCommodity orderCommodity1 = new OrderCommodity();
        orderCommodity1.setCommodityName("鸡排饭");
        orderCommodity1.setOriginalPrice(12);
        orderCommodity1.setUnitPrice(10);
        orderCommodity1.setQuantity(2);
        orderCommodity1.setTotalPrice(20);
        orderCommodity1.setOrderId(1L);
        OrderCommodity orderCommodity2 = new OrderCommodity();
        orderCommodity2.setCommodityName("鳕鱼饭");
        orderCommodity2.setOriginalPrice(7);
        orderCommodity2.setUnitPrice(5);
        orderCommodity2.setQuantity(3);
        orderCommodity2.setTotalPrice(15);
        orderCommodity2.setOrderId(1L);

        List<OrderCommodity> orderCommodityList = new ArrayList<>();
        orderCommodityList.add(orderCommodity1);
        orderCommodityList.add(orderCommodity2);
        order.setOrderCommodityList(orderCommodityList);

        OrderExecution orderExecution = orderService.addOrder(order);
        Assert.assertEquals(1, orderExecution.getState());
    }
}
