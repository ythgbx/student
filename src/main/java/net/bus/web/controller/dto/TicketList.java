package net.bus.web.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-26.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketList extends BaseResult {

    private List<TicketItem> tickets;
    private Integer page;
    private Integer total_count;

    public List<TicketItem> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketItem> tickets) {
        this.tickets = tickets;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }
}
