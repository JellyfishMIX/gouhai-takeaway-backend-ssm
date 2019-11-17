package com.jellyfishmix.gouhaitakeaway.entity;

import java.util.List;

public class Order {
    // 使用引用类型的原因：避免基础类型导致的被赋默认值
    private Long orderId;
    private String customerName;
    private Long customerPhone;
    private String customerAddr;
    private Integer totalPrice;
    private List<OrderCommodity> orderCommodityList;

    // Getter & Setter

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(Long customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCustomerAddr() {
        return customerAddr;
    }

    public void setCustomerAddr(String customerAddr) {
        this.customerAddr = customerAddr;
    }

    public List<OrderCommodity> getOrderCommodityList() {
        return orderCommodityList;
    }

    public void setOrderCommodityList(List<OrderCommodity> orderCommodityList) {
        this.orderCommodityList = orderCommodityList;
    }
}
