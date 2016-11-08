package net.bus.web.repository;

import net.bus.web.mapper.NewsMapper;
import net.bus.web.model.News;
import net.bus.web.model.NewsExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-10-09.
 */
@Repository
public class NewsRepository {

    @Autowired
    private NewsMapper _mapper;

    public List<News> getAll() {
        NewsExample example = new NewsExample();
        return _mapper.selectByExample(example);
    }

    public List<News> getAll(int page,int limit) {
        NewsExample example = new NewsExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<News>();
    }

    public List<News> getList(ISpecification specification) {
        NewsExample example = (NewsExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExample(example);
        }
        return new ArrayList<News>();
    }

    public int delete(Long id){return  _mapper.deleteByPrimaryKey(id);}

    public int delete(ISpecification specification){
        return _mapper.deleteByExample(
                (NewsExample) specification.createExample());
    }


    public List<News> getList(ISpecification specification,int page,int limit) {
        NewsExample example = (NewsExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<News>();
    }

    public News getItem(ISpecification specification) {
        List<News> list= _mapper.selectByExample((NewsExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public News getItem(Long id) {
        return _mapper.selectByPrimaryKey(id);
    }

    public int insertItem(News line)
    {
        return _mapper.insert(line);
    }

    public int updateItem(News line)
    {
        return _mapper.updateByPrimaryKey(line);
    }

    public boolean existItem(ISpecification specification){
        int result = _mapper.countByExample((NewsExample)specification.createExample());
        if(result>0)
            return true;

        return  false;
    }

    public int count(ISpecification specification)
    {
        NewsExample example = (NewsExample)specification.createExample();
        if(example!=null){
            return _mapper.countByExample(example);
        }
        return 0;
    }

    public int count()
    {
        return _mapper.countByExample(null);
    }
}
