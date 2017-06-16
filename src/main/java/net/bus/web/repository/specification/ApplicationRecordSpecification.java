package net.bus.web.repository.specification;

import net.bus.web.model.ApplicationRecordExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by yth on 2017/6/16.
 */
public class ApplicationRecordSpecification implements ISpecification<ApplicationRecordExample>{
    private String _idCard;

    public ApplicationRecordSpecification(String _idCard) {
        this._idCard = _idCard;
    }

    public ApplicationRecordExample createExample() {
        ApplicationRecordExample example = new ApplicationRecordExample();
        ApplicationRecordExample.Criteria criteria = example.createCriteria();
        if (this._idCard!=null){
            criteria.andIdcardEqualTo(_idCard);
        }

        return example;
    }
}
