package net.bus.web.repository;

import net.bus.web.mapper.UserCouponMapper;
import net.bus.web.model.UserCoupon;
import net.bus.web.model.UserCouponExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-08-04.
 */
@Repository
public class UserCouponRepository {

    @Autowired
    private UserCouponMapper _mapper;

    public List<UserCoupon> getList(ISpecification specification)
    {
        return _mapper.selectByExample((UserCouponExample)specification.createExample());
    }

    public List<UserCoupon> getList(ISpecification specification,int page,int limit)
    {
        return _mapper.selectByExampleWithRowbounds((UserCouponExample) specification.createExample(), new RowBounds(page, limit)); //分页
    }

    public UserCoupon getItem(ISpecification specification)
    {
        List<UserCoupon> list= _mapper.selectByExample((UserCouponExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }
        return null;
    }

    public int updateItem(UserCoupon coupon)
    {
        return  _mapper.updateByPrimaryKey(coupon);
    }

    public int insertItem(UserCoupon coupon)
    {
        return  _mapper.insert(coupon);
    }
}
