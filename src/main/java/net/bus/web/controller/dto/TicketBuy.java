package net.bus.web.controller.dto;

/**
 * Created by Edifi_000 on 2016-07-23.
 */
public class TicketBuy {

    private Long user_id;

    private Long line_id;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getLine_id() {
        return line_id;
    }

    public void setLine_id(Long line_id) {
        this.line_id = line_id;
    }
}
