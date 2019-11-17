package com.jellyfishmix.gouhaitakeaway.dao;

import com.jellyfishmix.gouhaitakeaway.BaseTest;
import com.jellyfishmix.gouhaitakeaway.entity.Order;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderDaoTest extends BaseTest {
    @Autowired
    private OrderDao orderDao;

    @Test
    @Ignore
    public void testInsertOrder() {
        Order order = new Order();
        order.setCustomerName("张全蛋");
        order.setCustomerPhone(13315766783L);
        order.setCustomerAddr("河北农业大学渤海校区");
        order.setTotalPrice(23);

        int effectedNum = orderDao.insertOrder(order);
        Assert.assertEquals(1, effectedNum);
    }
}
