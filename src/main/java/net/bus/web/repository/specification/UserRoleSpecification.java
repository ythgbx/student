package net.bus.web.repository.specification;

import net.bus.web.model.UserExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by yth on 2017/6/21.
 */
public class UserRoleSpecification implements ISpecification<UserExample> {
    private Integer _role;

    public UserRoleSpecification(int _role) {
        this._role = _role;
    }

    public UserExample createExample() {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (this._role!=null){
            criteria.andRoleEqualTo(_role);
        }
        return example;
    }
}
