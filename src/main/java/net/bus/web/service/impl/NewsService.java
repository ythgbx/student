package net.bus.web.service.impl;

import net.bus.web.model.News;
import net.bus.web.repository.NewsRepository;
import net.bus.web.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-10-09.
 */
@Service
public class NewsService implements INewsService{

    @Autowired
    private NewsRepository _rootRepository;

    public List<News> getAllNews(int page,int limit){
        return  _rootRepository.getAll(page-1,limit);
    }

    public int getAllNewsCount()
    {
        return _rootRepository.count();
    }

    public News getNewsDetails(Long id)
    {
        return _rootRepository.getItem(id);
    }

    public boolean addNews(News news){
        return false;
    }
}
