package com.jellyfishmix.gouhaitakeaway.web.commodity;

import com.jellyfishmix.gouhaitakeaway.dto.OrderExecution;
import com.jellyfishmix.gouhaitakeaway.entity.Order;
import com.jellyfishmix.gouhaitakeaway.enums.OrderStateEnum;
import com.jellyfishmix.gouhaitakeaway.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 新增订单
     * @param order
     * @return
     */
    @RequestMapping(value = "/addorder", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> addOrder(@RequestBody Order order) {
        Map<String, Object> modelMap = new HashMap<>();

        try {
            OrderExecution orderExecution = orderService.addOrder(order);
            if (orderExecution.getState() == OrderStateEnum.SUCCESS.getState()) {
                modelMap.put("success", true);
                return modelMap;
            } else {
                modelMap.put("success", false);
                modelMap.put("errState", orderExecution.getState());
                modelMap.put("errStateInfo", orderExecution.getStateInfo());
                return modelMap;
            }
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg: ", e.toString());
            return modelMap;
        }
    }

    /**
     * 删除订单及其关联的订单商品
     * @param order
     * @return
     */
    @RequestMapping(value = "/deleteorder", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> deleteOrder(@RequestBody Order order) {
        Map<String, Object> modelMap = new HashMap<>();

        try {
            OrderExecution orderExecution = orderService.deleteOrder(order);
            if (orderExecution.getState() == OrderStateEnum.SUCCESS.getState()) {
                modelMap.put("success", true);
                return modelMap;
            } else {
                modelMap.put("success", false);
                modelMap.put("errState", orderExecution.getState());
                modelMap.put("errStateInfo", orderExecution.getStateInfo());
                return modelMap;
            }
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
    }

    /**
     * 修改订单状态为已送达
     * @param order
     * @return
     */
    @RequestMapping(value = "/modifyordertoarrived", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> modifyOrderToArrived(@RequestBody Order order) {
        Map<String, Object> modelMap = new HashMap<>();
        OrderExecution orderExecution;

        try {
            orderExecution = orderService.modifyOrderToArrived(order);
            if (orderExecution.getState() == OrderStateEnum.SUCCESS.getState()) {
                modelMap.put("success", true);
                return modelMap;
            } else {
                modelMap.put("success", false);
                modelMap.put("errState", orderExecution.getState());
                modelMap.put("errStateInfo", orderExecution.getStateInfo());
                return modelMap;
            }
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
    }

    /**
     * 获取订单列表
     * @return
     */
    @RequestMapping(value = "/getorderlist", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getOrderList() {
        Map<String, Object> modelMap = new HashMap<>();
        List<Order> orderList;

        try {
            orderList = orderService.getOrderList();
            modelMap.put("success", true);
            modelMap.put("orderList", orderList);
            return modelMap;
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
    }
}
