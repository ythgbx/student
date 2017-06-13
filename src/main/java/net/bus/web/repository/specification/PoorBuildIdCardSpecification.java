package net.bus.web.repository.specification;

import net.bus.web.model.PoorBuildExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by yth on 2017/6/13.
 */
public class PoorBuildIdCardSpecification implements ISpecification<PoorBuildExample> {
    private String _IdCard;

    public PoorBuildIdCardSpecification(String _IdCard) {
        this._IdCard = _IdCard;
    }

    public PoorBuildExample createExample() {
        PoorBuildExample example = new PoorBuildExample();
        PoorBuildExample.Criteria criteria = example.createCriteria();
        if (this._IdCard!= null){
            criteria.andIdcardEqualTo(_IdCard);
        }
        return example;
    }
}
