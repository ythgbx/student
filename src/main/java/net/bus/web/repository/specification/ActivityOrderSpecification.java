package net.bus.web.repository.specification;

import net.bus.web.model.ActivityOrderExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by sky on 16/10/25.
 */
public class ActivityOrderSpecification implements ISpecification {

    private String _tradeNo;
    public ActivityOrderSpecification(String tradeNo){
        this._tradeNo = tradeNo;
    }
    //TODO ActivityOrderSpecification logical implement
    public Object createExample() {
        ActivityOrderExample example = new ActivityOrderExample();
        ActivityOrderExample.Criteria criteria = example.createCriteria();
        if(this._tradeNo!=null){
            criteria.andTradeNoEqualTo(this._tradeNo);
        }
        return example;
    }
}
