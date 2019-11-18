package com.jellyfishmix.gouhaitakeaway.enums;

public enum OrderStateEnum {
    SUCCESS(1, "操作成功"),
    INNER_ERROR(-1001, "内部错误"),
    EMPTY(-1002, "存在传参为空错误");

    private int state;
    private String stateInfo;
    private OrderStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    /**
     * 依据传入的state返回相应的return值。如根据传入的1返回"操作成功"，根据传入的-1001返回"内部错误"
     * @param state
     * @return
     */
    public static OrderStateEnum stateOf(int state) {
        for (OrderStateEnum stateEnum : values()) {
            if (stateEnum.getState() == state) {
                return stateEnum;
            }
        }
        return null;
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
}
