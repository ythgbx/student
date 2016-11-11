package net.bus.web.service.impl;

import net.bus.web.enums.OrderTypeEnum;
import net.bus.web.enums.ProducedTypeEnum;
import net.bus.web.model.Activity;
import net.bus.web.model.Orders;
import net.bus.web.model.Pojo.AsyncCallBack;
import net.bus.web.model.Pojo.OrderCallBack;
import net.bus.web.model.Pojo.Product;
import net.bus.web.model.User;
import net.bus.web.repository.ActivityRepository;
import net.bus.web.repository.specification.ActivitySpecification;
import net.bus.web.service.IActivityService;
import net.bus.web.service.IAlipayService;
import net.bus.web.service.IOrderService;
import net.bus.web.service.IProductService;
import net.bus.web.service.exception.ActivityException;
import net.bus.web.service.exception.OutOfStockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sky on 16/10/13.
 */

@Service("activityService")
public class ActivityService implements IActivityService,IProductService {
    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private IAlipayService alipayService;

    @Autowired
    private UserService _userService;

    @Autowired
    private IOrderService _orderService;


    @Value("#{sysProperties['payDebug']}")
    private Boolean _payDebug;

    public List<Activity> getAllActivity(int page,int limit){
        return activityRepository.getAll(page,limit);
    }

    public List<Orders> getUserActivity(User user, int page, int limit){
        return _orderService.getUserOrders(user.getId(),ProducedTypeEnum.ACTIVITY,page,limit);
    }

    public int getUserActivityCount(User user){

        return _orderService.getUserOrdersCount(user.getId(),ProducedTypeEnum.ACTIVITY);
    }

    public List<Activity> getActivityByIds(List<Long> ids){
        if(ids!=null && ids.size()>0){
            return activityRepository.getList(new ActivitySpecification(ids));
        }else {
            return new ArrayList<Activity>();
        }
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

    @Transactional
    public OrderCallBack join(OrderTypeEnum orderType,Long id, User user){
        Activity activity= activityRepository.getItem(id);
        int count = _orderService.getProductOrdersCount(activity.getId(), ProducedTypeEnum.ACTIVITY);
        if(activity!=null){
            if(count < activity.getUpperLimit()){
                Product product = new Product();
                product.setId(activity.getId());
                product.setSubject(activity.getTitle());
                product.setBody(activity.getDetail());
                product.setType(ProducedTypeEnum.ACTIVITY);
                //测试使用价格
                if(_payDebug){
                    product.setPrice(BigDecimal.valueOf(0.01));
                }else{
                    product.setPrice(activity.getPrice());
                }
                return _orderService.submit(user.getId(),orderType,product,1);//目前就一个人参加活动
            }
        }
        return null;
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


    @Transactional
    public boolean buyComplete(AsyncCallBack callBack) {
        Orders order = _orderService.query(callBack.getSelfTradeNo());
        if(order!=null&&order.getPayTime()==null){

            Activity activity = activityRepository.getItem(order.getProductId());
            User user = _userService.getUser(order.getUserId());
            int count = _orderService.getProductOrdersCount(activity.getId(), ProducedTypeEnum.ACTIVITY);

            //判断商品与用户是否存在合法
            if(activity!=null&&user!=null){
                //TODO 订单完成后更新活动参与人数
                if(count < activity.getUpperLimit()){
                    activity.setNumberOfPeople(activity.getNumberOfPeople()+1);
                    int result = activityRepository.updateItem(activity);
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
