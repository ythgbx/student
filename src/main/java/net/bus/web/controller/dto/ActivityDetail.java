package net.bus.web.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by sky on 16/10/13.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActivityDetail extends BaseResult{
    private Long id;
    private String img;
    private String introduction;
    private String content;
    private String scope;
    private Long time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
