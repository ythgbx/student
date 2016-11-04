package net.bus.web.service;

import net.bus.web.model.News;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-10-09.
 */
public interface INewsService {

    List<News> getAllNews(int page,int limit);

    int getAllNewsCount();

    News getNewsDetails(Long id);

    boolean addNews(News news);

    boolean delete(List<Long> ids);

    boolean delete(Long id);
}
