package net.bus.web.controller.dto;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-23.
 */
public class TicketBuy {

    private List<TicketBuyItem> ticket_buy_items;

    private String device;

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public List<TicketBuyItem> getTicket_buy_items() {
        return ticket_buy_items;
    }

    public void setTicket_buy_items(List<TicketBuyItem> ticket_buy_items) {
        this.ticket_buy_items = ticket_buy_items;
    }
}
