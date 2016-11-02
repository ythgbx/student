package net.bus.web.enums;

import net.bus.web.context.ApplicationContextProvider;
import net.bus.web.service.IPayService;
import net.bus.web.service.impl.ActivityService;
import net.bus.web.service.impl.CommodityService;

/**
 * Created by sky on 16/10/26.
 */
public enum ProducedTypeEnum {
    COMMODITY(1,"商品",(IPayService) ApplicationContextProvider.getApplicationContext().getBean(CommodityService.class),'C'),
    ACTIVITY(2,"活动",(IPayService)  ApplicationContextProvider.getApplicationContext().getBean(ActivityService.class),'A');


    private int index;
    private String name;
    private IPayService service;
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

    public IPayService getService() {
        return service;
    }

    public void setService(IPayService service) {
        this.service = service;
    }

    public char getPre() {
        return pre;
    }

    public void setPre(char pre) {
        this.pre = pre;
    }

    ProducedTypeEnum(int i, String name, IPayService service,char pre) {
        this.index = i;
        this.name = name;
        this.service = service;
        this.pre = pre;
    }

    public static ProducedTypeEnum get(int index){
        for (ProducedTypeEnum state : values()) {
            if (state.getIndex() == index) {
                return state;
            }
        }
        return null;
    }
}
