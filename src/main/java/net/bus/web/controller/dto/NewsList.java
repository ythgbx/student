package net.bus.web.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-10-09.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewsList extends BaseResult {

    private List<NewsItem> news;
    private Integer page;
    private Integer total_count;

    public List<NewsItem> getNews() {
        return news;
    }

    public void setNews(List<NewsItem> news) {
        this.news = news;
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
