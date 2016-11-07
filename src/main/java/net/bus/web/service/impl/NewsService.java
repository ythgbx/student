package net.bus.web.service.impl;

import net.bus.web.model.News;
import net.bus.web.repository.NewsRepository;
import net.bus.web.repository.specification.NewsSpecification;
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
       if(_rootRepository.insertItem(news)>0){
           return true;
       }
        return false;
    }

    public boolean delete(List<Long> ids) {
        NewsSpecification newsSpecification=new NewsSpecification(ids);
        int result;
        if(ids.size()==1){
            result=_rootRepository.delete(ids.get(0));
        }else{
            result=_rootRepository.delete(newsSpecification);
        }
        if(result>0){
            return true;
        }
        return false;
    }

    public boolean delete(Long id) {
        if(_rootRepository.delete(id)>0){
            return  true;
        }
        return false;
    }
}
