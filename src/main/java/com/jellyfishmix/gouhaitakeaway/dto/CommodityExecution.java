package com.jellyfishmix.gouhaitakeaway.dto;

import com.jellyfishmix.gouhaitakeaway.entity.Commodity;
import com.jellyfishmix.gouhaitakeaway.enums.CommodityStateEnum;

public class CommodityExecution {
    private int state;
    private String stateInfo;
    private Commodity commodity;

    public CommodityExecution() {

    }

    public CommodityExecution(CommodityStateEnum commodityStateEnum) {
        this.state = commodityStateEnum.getState();
        this.stateInfo = commodityStateEnum.getStateInfo();
    }

    public CommodityExecution(CommodityStateEnum commodityStateEnum, Commodity commodity) {
        this.state = commodityStateEnum.getState();
        this.stateInfo = commodityStateEnum.getStateInfo();
        this.commodity = commodity;
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

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }
}
