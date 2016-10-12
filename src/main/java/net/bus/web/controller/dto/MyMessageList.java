package net.bus.web.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by sky on 16/10/12.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyMessageList extends BaseResult{

    private List<MyMessageItem> message;
    private Integer page;
    private Integer total_count;

    public List<MyMessageItem> getMessage() {
        return message;
    }

    public void setMessage(List<MyMessageItem> message) {
        this.message = message;
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
