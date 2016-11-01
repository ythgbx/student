package net.bus.web.enums;

/**
 * Created by Edifi_000 on 2016-10-31.
 */
public enum  OrderTypeEnum {
    ALIPAY (1,"支付宝"),
    WXPAY (2,"微信");

    private int index;
    private String name;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    OrderTypeEnum(int i, String name) {
        this.index = i;
        this.name = name;
    }

    public static OrderTypeEnum get(int index){
        for (OrderTypeEnum state : values()) {
            if (state.getIndex() == index) {
                return state;
            }
        }
        return null;
    }
}
