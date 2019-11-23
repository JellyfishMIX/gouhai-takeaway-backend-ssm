package com.jellyfishmix.gouhaitakeaway.dao;

import com.jellyfishmix.gouhaitakeaway.BaseTest;
import com.jellyfishmix.gouhaitakeaway.entity.Order;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class OrderDaoTest extends BaseTest {
    @Autowired
    private OrderDao orderDao;

    @Test
    @Ignore
    public void testInsertOrder() {
        Order order = new Order();
        order.setCustomerName("张全蛋");
        order.setCustomerPhone("13315766783");
        order.setCustomerAddr("河北农业大学渤海校区");
        order.setTotalPrice(23);
        order.setCreateTime(new Date());
        order.setArrived(false);

        int effectedNum = orderDao.insertOrder(order);
        Assert.assertEquals(1, effectedNum);
    }

    @Test
    public void testUpdateOrder() {
        Order order = new Order();
        order.setOrderId(1L);
        order.setArrived(true);
        int effectedNum = orderDao.updateOrder(order);
        Assert.assertEquals(1, effectedNum);
    }

    @Test
    @Ignore
    public void testQueryOrderList() {
        List<Order> orderList = orderDao.queryOrderList();
        Assert.assertEquals(5, orderList.size());
    }
}
