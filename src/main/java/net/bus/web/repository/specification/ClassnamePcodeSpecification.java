package net.bus.web.repository.specification;

import net.bus.web.model.ClassnameExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by yth on 2017/6/11.
 */
public class ClassnamePcodeSpecification implements ISpecification<ClassnameExample> {
    private String _pcode;

    public ClassnamePcodeSpecification(String _pcode) {
        this._pcode = _pcode;
    }

    public ClassnameExample createExample() {
        ClassnameExample example = new ClassnameExample();
        ClassnameExample.Criteria criteria = example.createCriteria();
        if (_pcode!=null){
            criteria.andPcodeEqualTo(_pcode);
        }
        return example;
    }
}
