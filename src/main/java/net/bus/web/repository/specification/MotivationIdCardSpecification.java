package net.bus.web.repository.specification;

import net.bus.web.model.MotivationalExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by yth on 2017/6/23.
 */
public class MotivationIdCardSpecification implements ISpecification<MotivationalExample> {
    private String _IdCard;

    public MotivationIdCardSpecification(String _IdCard) {
        this._IdCard = _IdCard;
    }

    public MotivationalExample createExample() {
        MotivationalExample example = new MotivationalExample();
        MotivationalExample.Criteria criteria = example.createCriteria();
        if (this._IdCard!=null){
            criteria.andIdcardEqualTo(_IdCard);
        }
        return example;
    }
}
