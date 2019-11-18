package com.jellyfishmix.gouhaitakeaway.dto;

import com.jellyfishmix.gouhaitakeaway.entity.Order;
import com.jellyfishmix.gouhaitakeaway.enums.OrderStateEnum;

public class OrderExecution {
    private int state;
    private String stateInfo;
    private Order order;

    public OrderExecution() {

    }

    public OrderExecution(OrderStateEnum orderStateEnum) {
        this.state = orderStateEnum.getState();
        this.stateInfo = orderStateEnum.getStateInfo();
    }

    public OrderExecution(OrderStateEnum orderStateEnum, Order order) {
        this.state = orderStateEnum.getState();
        this.stateInfo = orderStateEnum.getStateInfo();
        this.order = order;
    }

    // Getter & Setter

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
