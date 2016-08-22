package net.bus.web.controller.dto;

/**
 * Created by Edifi_000 on 2016-08-22.
 */
public class CouponRequest extends BaseRequest{

    private Long user_id;
    private Long start;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }
}
