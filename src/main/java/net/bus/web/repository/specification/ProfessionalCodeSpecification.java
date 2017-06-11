package net.bus.web.repository.specification;

import net.bus.web.model.ProfessionalExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by yth on 2017/6/11.
 */
public class ProfessionalCodeSpecification implements ISpecification<ProfessionalExample> {
    private String _code;

    public ProfessionalCodeSpecification(String code) {
        this._code = code;
    }

    public ProfessionalExample createExample() {
        ProfessionalExample example = new ProfessionalExample();
        ProfessionalExample.Criteria criteria = example.createCriteria();
        if (this._code!=null){
            criteria.andCodeEqualTo(_code);
        }
        return example;
    }
}
