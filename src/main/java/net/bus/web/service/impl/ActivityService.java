package net.bus.web.service.impl;

import net.bus.web.model.Pojo.AlipayAsyncCallBack;
import net.bus.web.enums.ProducedTypeEnum;
import net.bus.web.model.Activity;
import net.bus.web.model.ActivityOrder;
import net.bus.web.model.User;
import net.bus.web.repository.ActivityOrderRepository;
import net.bus.web.repository.ActivityRepository;
import net.bus.web.repository.specification.ActivityOrderSpecification;
import net.bus.web.repository.specification.ActivitySpecification;
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
        return activityRepository.getAll(page,limit);
    }

    public int getAllActivityCount(){
        return activityRepository.count();
    }

    public Activity getActivityDetails(Long id){
        return activityRepository.getItem(id);
    }

    public boolean addActivity(Activity activity){
        if(activityRepository.insertItem(activity)>0){
            return  true;
        }

        return false;
    }

    public boolean deleteActivity(Long id) {
        if(activityRepository.deleteByPrimaryKey(id)>0){
            return  true;
        }
        return false;
    }

    public boolean delete(List<Long> ids) {
        ActivitySpecification activitySpecification=new ActivitySpecification(ids);
        int result;
        if(ids.size()==1){
            result=activityRepository.deleteByPrimaryKey(ids.get(0));
        }else{
        result = activityRepository.deleteByExample( activitySpecification);
        }
        if(result>0){
            return true;
        }
        return false;
    }


    public String join(Long id, User user) {
        Activity activity= activityRepository.getItem(id);
        int count = activityOrderRepository.count(new ActivityOrderSpecification(id));
        String sign = null;
        if(activity!=null){
            if(count < activity.getUpperLimit()){
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
    }

    public boolean updateActivity(Activity activity) {
        if(activityRepository.updateItem(activity)>0){
            return  true;
        }
        return false;
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
    public boolean buyComplete(AlipayAsyncCallBack callBack) {
        ActivityOrder order = activityOrderRepository.getItem(new ActivityOrderSpecification(callBack.getOutTradeNo()));
        if(order!=null&&order.getPayTime()==null){

            Activity activity = activityRepository.getItem(order.getActivityId());
            User user = _userService.getUser(order.getUserId());
            int count = activityOrderRepository.count(new ActivityOrderSpecification(order.getActivityId()));

            //判断商品与用户是否存在合法
            if(activity!=null&&user!=null){
                //TODO 订单完成后更新活动参与人数
                if(count < activity.getUpperLimit()){
                    order.setPay(BigDecimal.valueOf(Double.valueOf(callBack.getAmount())));
                    order.setPayTime(new Date());
                    activity.setNumberOfPeople(activity.getNumberOfPeople()+1);
                    int result = activityOrderRepository.updateItem(order);
                    if(result < 1){
                        throw new ActivityException("更新订单异常");
                    }
                    result = activityRepository.updateItem(activity);
                    if(result < 1){
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
