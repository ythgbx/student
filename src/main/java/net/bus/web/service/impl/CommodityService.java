package net.bus.web.service.impl;

import net.bus.web.model.Commodity;
import net.bus.web.model.CommodityOrder;
import net.bus.web.model.User;
import net.bus.web.model.type.PointRecordType;
import net.bus.web.model.type.PointSourceType;
import net.bus.web.model.type.UserCouponType;
import net.bus.web.repository.CommodityOrderRepository;
import net.bus.web.repository.CommodityRepository;
import net.bus.web.service.ICommodityService;
import net.bus.web.service.IPointRecordService;
import net.bus.web.service.IUserCouponService;
import net.bus.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-09-04.
 */
@Service
public class CommodityService implements ICommodityService{

    @Autowired
    private CommodityRepository _rootRepository;
    @Autowired
    private CommodityOrderRepository _commodityOrderRepository;
    @Autowired
    private IUserCouponService _userCouponService;
    @Autowired
    private IUserService _userService;
    @Autowired
    private IPointRecordService _pointRecordService;

    public List<Commodity> getAll(int page,int limit)
    {
        return _rootRepository.getAll(page - 1, limit);
    }

    public Commodity getDetails(Long id)
    {
        return _rootRepository.getItem(id);
    }

    @Transactional
    public boolean buy(long commodity_id,User user) throws RuntimeException
    {
        Commodity commodity = getDetails(commodity_id);
        if(commodity!=null){
            if(commodity.getAmount()>0){
                CommodityOrder order = new CommodityOrder();
                order.setCommodityId(commodity_id);
                order.setUserId(user.getId());
                order.setAmount(1);//TODO 是否需要减少库存(暂时补进行库存处理,均为虚拟商品)
                order.setPrice(commodity.getPrice());
                order.setPay(BigDecimal.valueOf(0));//TODO 暂时不完成已支付金额的填写
                _commodityOrderRepository.insertItem(order);

                if (commodity.getTypeId().equals(1L)){
                    //Add 积分
                    _userService.addPoint(user,commodity.getPoint());
                    //Add 积分变化记录
                    _pointRecordService.recordPoint(user.getId(), PointRecordType.Income, PointSourceType.COMMODITY,commodity.getPoint(),commodity.getName());
                }else if(commodity.getTypeId().equals(2L)){
                    //Add coupon
                    if(commodity.getCouponType().equals(UserCouponType.MonthlyTicket.ordinal())){
                        _userCouponService.addMonthlyTicket(user.getId(),new Date(),"","");
                    }else if(commodity.getCouponType().equals(UserCouponType.YearlyTicket.ordinal())){
                        _userCouponService.addYearlyTicketTicket(user.getId(),new Date(),"","");
                    }
                }
                return true;
            }
        }
        return false;
    }

    public int getAllCount()
    {
        return _rootRepository.count();
    }
}
