package com.jellyfishmix.gouhaitakeaway.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class Order {
    // 使用引用类型的原因：避免基础类型导致的被赋默认值
    private Long orderId;
    private String customerName;
    private String customerPhone;
    private String customerAddr;
    private Integer totalPrice;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd   HH:mm:ss")
    private Date createTime;
    private Boolean isArrived;  // 订单是否已送达
    private List<OrderCommodity> orderCommodityList;

    // Getter & Setter

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddr() {
        return customerAddr;
    }

    public void setCustomerAddr(String customerAddr) {
        this.customerAddr = customerAddr;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonProperty(value = "isArrived")
    public Boolean getArrived() {
        return isArrived;
    }

    @JsonProperty(value = "isArrived")
    public void setArrived(Boolean arrived) {
        isArrived = arrived;
    }

    public List<OrderCommodity> getOrderCommodityList() {
        return orderCommodityList;
    }

    public void setOrderCommodityList(List<OrderCommodity> orderCommodityList) {
        this.orderCommodityList = orderCommodityList;
    }
}
