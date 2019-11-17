package com.jellyfishmix.gouhaitakeaway.dao;

import com.jellyfishmix.gouhaitakeaway.BaseTest;
import com.jellyfishmix.gouhaitakeaway.entity.OrderCommodity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class OrderCommodityDaoTest extends BaseTest {
    @Autowired
    private OrderCommodityDao orderCommodityDao;

    @Test
    public void testBatchInsertOrderCommodity() {
        OrderCommodity orderCommodity1 = new OrderCommodity();
        orderCommodity1.setCommodityName("卤肉饭");
        orderCommodity1.setOriginalPrice(12);
        orderCommodity1.setUnitPrice(10);
        orderCommodity1.setQuantity(2);
        orderCommodity1.setTotalPrice(20);
        orderCommodity1.setOrderId(1L);
        OrderCommodity orderCommodity2 = new OrderCommodity();
        orderCommodity2.setCommodityName("可乐");
        orderCommodity2.setOriginalPrice(7);
        orderCommodity2.setUnitPrice(5);
        orderCommodity2.setQuantity(3);
        orderCommodity2.setTotalPrice(15);
        orderCommodity2.setOrderId(1L);

        List<OrderCommodity> orderCommodityList = new ArrayList<OrderCommodity>();
        orderCommodityList.add(orderCommodity1);
        orderCommodityList.add(orderCommodity2);

        int effectedNum = orderCommodityDao.batchInsertOrderCommodity(orderCommodityList);
        Assert.assertEquals(2, effectedNum);
    }
}
