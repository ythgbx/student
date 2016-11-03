package net.bus.web.controller.dto;

import java.util.List;

/**
 * Created by sky on 16/7/16.
 */
public class BaseRequest {

    private Long id;

    private List<Long> ids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIds(List<Long> ids){ this.ids=ids;}

    public List<Long> getIds(){return ids;}
}
