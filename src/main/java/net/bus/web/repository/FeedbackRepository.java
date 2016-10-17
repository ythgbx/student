package net.bus.web.repository;

import net.bus.web.mapper.FeedbackMapper;
import net.bus.web.model.Feedback;
import net.bus.web.model.FeedbackExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 16/10/13.
 */
@Repository
public class FeedbackRepository {
    @Autowired
    private FeedbackMapper _feedbackMapper;

    public List<Feedback> getAll() {
        FeedbackExample example = new FeedbackExample();
        return _feedbackMapper.selectByExample(example);
    }

    public List<Feedback> getAll(int page,int limit) {
        FeedbackExample example = new FeedbackExample();
        if(example!=null) {
            return _feedbackMapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<Feedback>();
    }

    public List<Feedback> getList(ISpecification specification) {
        FeedbackExample example = (FeedbackExample)specification.createExample();
        if(example!=null) {
            return _feedbackMapper.selectByExample(example);
        }
        return new ArrayList<Feedback>();
    }

    public List<Feedback> getList(ISpecification specification,int page,int limit) {
        FeedbackExample example = (FeedbackExample)specification.createExample();
        if(example!=null) {
            return _feedbackMapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<Feedback>();
    }

    public Feedback getItem(ISpecification specification) {
        List<Feedback> list= _feedbackMapper.selectByExample((FeedbackExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public Feedback getItem(Long id) {
        return _feedbackMapper.selectByPrimaryKey(id);
    }

    public int insertItem(Feedback feedback)
    {
        return _feedbackMapper.insert(feedback);
    }

    public int updateItem(Feedback feedback)
    {
        return _feedbackMapper.updateByPrimaryKey(feedback);
    }

    public boolean existItem(ISpecification specification){
        int result = _feedbackMapper.countByExample((FeedbackExample) specification.createExample());
        if(result>0)
            return true;

        return  false;
    }

    public int count(ISpecification specification)
    {
        FeedbackExample example = (FeedbackExample)specification.createExample();
        if(example!=null){
            return _feedbackMapper.countByExample(example);
        }
        return 0;
    }

    public int count()
    {
        return _feedbackMapper.countByExample(null);
    }
}

