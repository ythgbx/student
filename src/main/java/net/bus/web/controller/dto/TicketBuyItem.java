package net.bus.web.controller.dto;

/**
 * Created by Edifi_000 on 2016-08-29.
 */
public class TicketBuyItem {

    private Long user_id;

    private Long check_date;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getCheck_date() {
        return check_date;
    }

    public void setCheck_date(Long check_date) {
        this.check_date = check_date;
    }
}
