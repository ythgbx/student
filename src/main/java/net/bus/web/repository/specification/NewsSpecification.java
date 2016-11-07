package net.bus.web.repository.specification;


import net.bus.web.model.NewsExample;
import net.bus.web.repository.ISpecification;

import java.util.List;

/**
 * Created by sky on 16/11/4.
 */
public class NewsSpecification implements ISpecification<NewsExample>{
    protected List<Long> _ids;
    public NewsSpecification(List<Long> ids){
        this._ids=ids;
    }
    public NewsExample createExample() {
        NewsExample newsExample=new NewsExample();
        if(_ids!=null&&_ids.isEmpty()){
            NewsExample.Criteria criteria=newsExample.createCriteria();
            criteria.andIdIn(_ids);
        }
        return newsExample;
    }
}
