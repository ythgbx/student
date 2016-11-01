package net.bus.web.service.impl;

import net.bus.web.context.AlipayCallBack;
import net.bus.web.enums.ProducedTypeEnum;
import net.bus.web.model.Activity;
import net.bus.web.model.ActivityOrder;
import net.bus.web.model.User;
import net.bus.web.repository.ActivityOrderRepository;
import net.bus.web.repository.ActivityRepository;
import net.bus.web.repository.specification.ActivityOrderSpecification;
import net.bus.web.service.IActivityService;
import net.bus.web.service.IAlipayService;
import net.bus.web.service.IPayService;
import net.bus.web.service.exception.ActivityException;
import net.bus.web.service.exception.OutOfStockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by sky on 16/10/13.
 */

@Service("activityService")
public class ActivityService implements IActivityService,IPayService {
    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ActivityOrderRepository activityOrderRepository;

    @Autowired
    private IAlipayService alipayService;

    @Autowired
    private UserService _userService;

    @Value("#{sysProperties['payDebug']}")
    private Boolean _payDebug;

    public List<Activity> getAllActivity(int page,int limit){
        return activityRepository.getAll(page-1,limit);
    }

    public int getAllActivityCount(){
        return activityRepository.count();
    }

    public Activity getActivityDetails(Long id){
        return activityRepository.getItem(id);
    }

    public boolean addActivity(Activity activity){
        return false;
    }


    public String join(Long id, User user) {
        Activity activity= activityRepository.getItem(id);

        String sign = null;
        if(activity!=null){
            if(activity.getAmount()>0){
                ActivityOrder order = new ActivityOrder();
                order.setAmount(1); //目前就一个人参加活动
                order.setTradeNo(getOutTradeNo());
                order.setUserId(user.getId());
                order.setActivityId(activity.getId());
                //测试使用价格
                if(_payDebug){
                    order.setPrice(BigDecimal.valueOf(0.01));
                }else{
                    order.setPrice(activity.getPrice());
                }
                order.setPay(BigDecimal.valueOf(0));

                sign = alipayService.sign(order.getTradeNo(),activity.getTitle(),activity.getDetail(),order.getPrice().toString());
                int result = activityOrderRepository.insertItem(order);
            }
        }
        return sign;

//        Activity activity= activityRepository.getItem(id);
//        if(isActivityStart(activity)){
//            int result = activityRepository.reduceAmount(id);
//            if (result>0){
//                ActivityOrder activityOrder = new ActivityOrder();
//                activityOrder.setUserId(user.getId());
//                activityOrder.setActivityId(id);
//
//                result = activityOrderRepository.insertItem(activityOrder);
//                if(result > 0){
//                    return true;
//                }else{
//                    throw new RepeatApplyException("重复下单");
//                }
//            }else{
//                throw new OutOfStockException("商品已售完");
//            }
//        }else{
//            throw new ActivityException("活动没开始或已经结束");
//        }
    }

    public boolean isActivityStart(Long id){
        Activity activity= activityRepository.getItem(id);
        Date date = new Date();
        return date.getTime()>activity.getStartime().getTime()
                && date.getTime()<activity.getEndtime().getTime();
    }
    public boolean isActivityStart(Activity activity){
        Date date = new Date();
        return date.getTime()>activity.getStartime().getTime()
                && date.getTime()<activity.getEndtime().getTime();
    }


    public String getOutTradeNo() {
        return ProducedTypeEnum.ACTIVITY.getIndex() + UUID.randomUUID().toString().replace("-", "");
    }

    @Transactional
    public boolean buyComplete(AlipayCallBack callBack) {
        ActivityOrder order = activityOrderRepository.getItem(new ActivityOrderSpecification(callBack.getOutTradeNo()));
        if(order!=null&&order.getPayTime()==null){

            Activity activity = activityRepository.getItem(order.getActivityId());
            User user = _userService.getUser(order.getUserId());

            //判断商品与用户是否存在合法
            if(activity!=null&&user!=null){
                //TODO 根据是否需要减少库存(暂时补进行库存处理,均为虚拟商品) 判断库存后进行操作
                if(activity.getAmount()>0){
                    order.setPay(BigDecimal.valueOf(Double.valueOf(callBack.getAmount())));
                    order.setPayTime(new Date());
                    int result = activityOrderRepository.updateItem(order);
                    if(result>0){
                        throw new ActivityException("更新订单异常");
                    }
                    result = activityRepository.reduceAmount(order.getId());
                    if(result>0){
                        throw new ActivityException("更新库存异常");
                    }
                    return true;
                }else{
                    throw new OutOfStockException("活动报名人数已满");
                }
            }
        }
        return false;
    }
}
