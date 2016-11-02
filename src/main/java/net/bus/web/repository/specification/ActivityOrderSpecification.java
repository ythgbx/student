package net.bus.web.repository.specification;

import net.bus.web.model.ActivityOrderExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by sky on 16/10/25.
 */
public class ActivityOrderSpecification implements ISpecification {

    private String _tradeNo;
    private Long activity_id;
    public ActivityOrderSpecification(String tradeNo){
        this._tradeNo = tradeNo;
    }
    public ActivityOrderSpecification(Long activity_id){
        this.activity_id = activity_id;
    }
    //TODO ActivityOrderSpecification logical implement
    public Object createExample() {
        ActivityOrderExample example = new ActivityOrderExample();
        ActivityOrderExample.Criteria criteria = example.createCriteria();
        if(this._tradeNo!=null){
            criteria.andTradeNoEqualTo(this._tradeNo);
        }
        if(this.activity_id != null && this.activity_id !=0 ){
            criteria.andActivityIdEqualTo(this.activity_id);
        }
        return example;
    }
}
