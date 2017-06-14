package net.bus.web.repository.specification;

import net.bus.web.model.GrantExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by yth on 2017/6/13.
 */
public class GrantidCardSpecification implements ISpecification<GrantExample>{
    private String _idCard;

    public GrantidCardSpecification(String _idCard) {
        this._idCard = _idCard;
    }

    public GrantExample createExample() {
        GrantExample example = new GrantExample();
        GrantExample.Criteria criteria = example.createCriteria();
        if (this._idCard!=null) {
            criteria.andIdcardEqualTo(_idCard);
        }
        return example;
    }
}
