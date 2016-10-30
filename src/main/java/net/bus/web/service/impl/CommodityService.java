package net.bus.web.service.impl;

import net.bus.web.context.AlipayCallBack;
import net.bus.web.enums.ProducedTypeEnum;
import net.bus.web.model.Commodity;
import net.bus.web.model.CommodityOrder;
import net.bus.web.model.User;
import net.bus.web.model.type.PointRecordType;
import net.bus.web.model.type.PointSourceType;
import net.bus.web.model.type.UserCouponType;
import net.bus.web.repository.CommodityOrderRepository;
import net.bus.web.repository.CommodityRepository;
import net.bus.web.repository.specification.CommodityIdsSpecification;
import net.bus.web.repository.specification.CommodityOrderTradeNoSpecification;
import net.bus.web.repository.specification.CommodityOrderUserIdAndPaied;
import net.bus.web.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Edifi_000 on 2016-09-04.
 */
@Service("commodityService")
public class CommodityService implements ICommodityService,IPayService{

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
    @Autowired
    private IAlipayService _alipayService;

    @Value("#{sysProperties['payDebug']}")
    private Boolean _payDebug;

    public List<Commodity> getAll(int page,int limit)
    {
        return _rootRepository.getAll(page - 1, limit);
    }

    public Commodity getDetails(Long id)
    {
        return _rootRepository.getItem(id);
    }

    @Transactional
    public String buy(long commodityId,User user) throws RuntimeException
    {
        String sign = null;
        Commodity commodity = getDetails(commodityId);
        if(commodity!=null){
            if(commodity.getAmount()>0){
                CommodityOrder order = new CommodityOrder();
                order.setTradeNo(getOutTradeNo());
                order.setCommodityId(commodityId);
                order.setUserId(user.getId());
                order.setAmount(1);
                //测试使用价格
                if(_payDebug){
                    order.setPrice(BigDecimal.valueOf(0.01));
                }else{
                    order.setPrice(commodity.getPrice());
                }
                order.setPay(BigDecimal.valueOf(0));

                sign = _alipayService.sign(order.getTradeNo(),commodity.getName(),commodity.getDepict(),order.getPrice().toString());
                _commodityOrderRepository.insertItem(order);
            }
        }

        return sign;
    }

    @Transactional
    public boolean buyComplete(AlipayCallBack callBack) throws RuntimeException
    {
        CommodityOrder commodityOrder = _commodityOrderRepository.getItem(new CommodityOrderTradeNoSpecification(callBack.getOutTradeNo()));
        if(commodityOrder!=null&&commodityOrder.getPayTime()==null){

            Commodity commodity = getDetails(commodityOrder.getCommodityId());
            User user = _userService.getUser(commodityOrder.getUserId());

            //判断商品与用户是否存在合法
            if(commodity!=null&&user!=null){
                //TODO 根据是否需要减少库存(暂时补进行库存处理,均为虚拟商品) 判断库存后进行操作
                if(commodity.getAmount()>0){
                    commodityOrder.setPay(BigDecimal.valueOf(Double.valueOf(callBack.getAmount())));
                    commodityOrder.setPayTime(new Date());
                    _commodityOrderRepository.updateItem(commodityOrder);

                    //处理相应商品逻辑如加积分或月卡年卡
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
        }
        return false;
    }

    public int getAllCount()
    {
        return _rootRepository.count();
    }

    public List<Commodity> getList(List<Long> ids){
        return _rootRepository.getList(new CommodityIdsSpecification(ids));
    }

    public String getOutTradeNo()
    {
        //TODO 生成订单编号
        return ProducedTypeEnum.COMMODITY.getIndex() + UUID.randomUUID().toString().replace("-", "");
    }

    public List<CommodityOrder> getUserOrders(long userId,int page,int limit){
        return _commodityOrderRepository.getList(new CommodityOrderUserIdAndPaied(userId), page - 1, limit);
    }

    public int getUserOrdersCount(long userId){
        return _commodityOrderRepository.count(new CommodityOrderUserIdAndPaied(userId));
    }
}
