package net.bus.web.repository.specification;

import net.bus.web.model.PointRecord;
import net.bus.web.model.PointRecordExample;
import net.bus.web.model.type.PointSourceType;
import net.bus.web.repository.ISpecification;

import java.util.Date;

/**
 * Created by sky on 16/7/27.
 */
public class UserPointRecordSpecification implements ISpecification<PointRecordExample>{

    private long userId;
    private PointSourceType source;
    public UserPointRecordSpecification(long userId){
        this.userId = userId;
    }
    public UserPointRecordSpecification(long userId, PointSourceType source){
        this.source= source;
        this.userId = userId;
    }
    public PointRecordExample createExample() {
        PointRecordExample example = new PointRecordExample();
        PointRecordExample.Criteria criteria = example.createCriteria();
        if(userId!=0){
            criteria.andUseridEqualTo(userId);
        }
        if (source!=null){
            criteria.andSourceEqualTo(source.toString());
        }
        example.setOrderByClause("record_time desc");
        return example;
    }
}
