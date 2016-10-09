package net.bus.web.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Edifi_000 on 2016-10-09.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewsDetail extends BaseResult{
    private Long id;
    private String title;
    private String author;
    private String type;
    private String content;
    private String img;
    private Long time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
