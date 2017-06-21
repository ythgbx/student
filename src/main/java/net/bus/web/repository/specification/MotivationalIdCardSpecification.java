package net.bus.web.repository.specification;

import net.bus.web.model.MotivationalExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by yth on 2017/6/20.
 */
public class MotivationalIdCardSpecification implements ISpecification<MotivationalExample> {
    private String _idCard;

    public MotivationalIdCardSpecification(String _idCard) {
        this._idCard = _idCard;
    }

    public MotivationalExample createExample() {
        MotivationalExample example = new MotivationalExample();
        MotivationalExample.Criteria criteria = example.createCriteria();
        if (this._idCard!=null)
        {
            criteria.andIdcardEqualTo(_idCard);
        }
        return example;
    }
}
