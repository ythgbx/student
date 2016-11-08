package net.bus.web.enums;

/**
 * Created by Edifi_000 on 2016-10-31.
 */
public enum  OrderTypeEnum {
    ALIPAY (1,"支付宝",'A'),
    WXPAY (2,"微信",'W');

    private int index;
    private String name;
    private char pre;

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

    public char getPre() {
        return pre;
    }

    public void setPre(char pre) {
        this.pre = pre;
    }

    OrderTypeEnum(int i, String name,char pre) {
        this.index = i;
        this.name = name;
        this.pre = pre;
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
