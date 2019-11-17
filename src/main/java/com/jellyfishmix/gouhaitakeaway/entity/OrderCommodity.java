package com.jellyfishmix.gouhaitakeaway.entity;

public class OrderCommodity {
    // 使用引用类型的原因：避免基础类型导致的被赋默认值
    private Long orderCommodityId;
    private String commodityName;
    private Integer originalPrice;  // 原价
    private Integer unitPrice;  // 单价，即现价
    private Integer quantity;
    private Integer totalPrice; // 单项合计
    private Long orderId;

    // Getter & Setter

    public Long getOrderCommodityId() {
        return orderCommodityId;
    }

    public void setOrderCommodityId(Long orderCommodityId) {
        this.orderCommodityId = orderCommodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public Integer getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
