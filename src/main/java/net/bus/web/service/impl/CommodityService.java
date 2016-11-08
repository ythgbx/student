package net.bus.web.service.impl;

import net.bus.web.enums.OrderTypeEnum;
import net.bus.web.enums.ProducedTypeEnum;
import net.bus.web.model.Commodity;
import net.bus.web.model.Orders;
import net.bus.web.model.Pojo.AlipayOrderCallBack;
import net.bus.web.model.Pojo.AsyncCallBack;
import net.bus.web.model.Pojo.Product;
import net.bus.web.model.User;
import net.bus.web.model.type.PointRecordType;
import net.bus.web.model.type.PointSourceType;
import net.bus.web.model.type.UserCouponType;
import net.bus.web.repository.CommodityRepository;
import net.bus.web.repository.specification.CommodityIdsSpecification;
import net.bus.web.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-09-04.
 */
@Service("commodityService")
public class CommodityService implements ICommodityService,IProductService {

    @Autowired
    private CommodityRepository _rootRepository;
    @Autowired
    private IUserCouponService _userCouponService;
    @Autowired
    private IUserService _userService;
    @Autowired
    private IPointRecordService _pointRecordService;
    @Autowired
    private IOrderService _orderService;

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

                Product product = new Product();
                product.setId(commodityId);
                product.setSubject(commodity.getName());
                product.setBody(commodity.getDepict());
                product.setType(ProducedTypeEnum.COMMODITY);
                //测试使用价格
                if(_payDebug){
                    product.setPrice(BigDecimal.valueOf(0.01));
                }else{
                    product.setPrice(commodity.getPrice());
                }

                sign = ((AlipayOrderCallBack)_orderService.submit(user.getId(), OrderTypeEnum.ALIPAY,product,1)).getSign();
            }
        }

        return sign;
    }

    public boolean buyComplete(AsyncCallBack callBack) throws RuntimeException
    {
        Orders commodityOrder = _orderService.query(callBack.getTradeNo());
        if(commodityOrder!=null&&commodityOrder.getPayTime()==null){

            Commodity commodity = getDetails(commodityOrder.getProductId());
            User user = _userService.getUser(commodityOrder.getUserId());

            //判断商品与用户是否存在合法
            if(commodity!=null&&user!=null){
                //TODO 根据是否需要减少库存(暂时补进行库存处理,均为虚拟商品) 判断库存后进行操作
                if(commodity.getAmount()>0){

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

    public List<Orders> getAllOrders(int page,int limit){
        return  _orderService.getAllOrders(ProducedTypeEnum.COMMODITY, page, limit);
    }

    public int getAllOrderCount(){ return _orderService.getAllOrdersCount(ProducedTypeEnum.COMMODITY);}

    public List<Orders> getUserOrders(long userId,int page,int limit){
        return _orderService.getUserOrders(userId, ProducedTypeEnum.COMMODITY, page, limit);
    }

    public int getUserOrdersCount(long userId){
        return _orderService.getUserOrdersCount(userId,ProducedTypeEnum.COMMODITY);
    }
}
