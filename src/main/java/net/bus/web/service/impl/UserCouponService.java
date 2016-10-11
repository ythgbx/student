package net.bus.web.service.impl;

import net.bus.web.model.UserCoupon;
import net.bus.web.model.type.UserCouponType;
import net.bus.web.repository.ISpecification;
import net.bus.web.repository.UserCouponRepository;
import net.bus.web.repository.specification.UserCouponTypeInStartAndEndTimeSpecification;
import net.bus.web.repository.specification.UserCouponUserIdSpecification;
import net.bus.web.repository.specification.UserCouponUserIdInStartAndEndTimeSpecification;
import net.bus.web.service.IUserCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

/**
 * Created by Edifi_000 on 2016-08-04.
 */
@Service
public class UserCouponService implements IUserCouponService {

    @Autowired
    private UserCouponRepository _rootRepository;

    public List<Long> getMonthlyTicketUserIdList()
    {
//        //获取当前月第一天：
//        Calendar cFirst = Calendar.getInstance();
//        cFirst.add(Calendar.MONTH, 0);
//        cFirst.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
//
//        //获取当前月最后一天
//        Calendar cLast = Calendar.getInstance();
//        cLast.set(Calendar.DAY_OF_MONTH, cLast.getActualMaximum(Calendar.DAY_OF_MONTH));

        ISpecification specification = new UserCouponTypeInStartAndEndTimeSpecification(UserCouponType.MonthlyTicket,new Date());

        List<UserCoupon> userCouponList = _rootRepository.getList(specification);
        List<Long> resultList = new ArrayList<Long>();
        if(userCouponList!=null){
            for (UserCoupon coupon:userCouponList){
                if(!resultList.contains(coupon.getUserId())){
                    resultList.add(coupon.getUserId());
                }
            }
        }

        return resultList;
    }

    public List<Long> getYearlyTicketUserIdList()
    {
        ISpecification specification = new UserCouponTypeInStartAndEndTimeSpecification(UserCouponType.YearlyTicket,new Date());

        List<UserCoupon> userCouponList = _rootRepository.getList(specification);
        List<Long> resultList = new ArrayList<Long>();
        if(userCouponList!=null){
            for (UserCoupon coupon:userCouponList){
                if(!resultList.contains(coupon.getUserId())){
                    resultList.add(coupon.getUserId());
                }
            }
        }

        return resultList;
    }


    public UserCoupon getUserTimePeriodTicketCoupon(long userId)
    {
//        ISpecification specification = new UserCouponUserIdInStartAndEndTimeSpecification(userId,new Date());
//        List<UserCoupon> userCouponList = _rootRepository.getList(specification);
        List<UserCoupon> userCouponList = getUserTimePeriodTicketCoupons(userId);
        UserCoupon yearTicketCoupon = null;
        UserCoupon monthlyTicket = null;

        for(UserCoupon coupon:userCouponList){
            if(coupon.getType().equals(UserCouponType.MonthlyTicket.ordinal())){
                if(monthlyTicket==null||monthlyTicket.getEndTime().before(coupon.getEndTime())){
                    monthlyTicket = coupon;
                }
            }

            if(coupon.getType().equals(UserCouponType.YearlyTicket.ordinal())){
                if(yearTicketCoupon==null||yearTicketCoupon.getEndTime().before(coupon.getEndTime())){
                    yearTicketCoupon = coupon;
                }
            }
        }

        if(yearTicketCoupon!=null){
            return yearTicketCoupon;
        }

        return monthlyTicket;
    }

    public boolean addMonthlyTicket(long userId,Date start,String image,String content)
    {
        List<UserCoupon>  userCoupons = getUserTimePeriodTicketCoupons(userId);
        if(userCoupons!=null){
            for (UserCoupon userCoupon:userCoupons){
                //if(userCoupon.getType().equals(UserCouponType.MonthlyTicket.ordinal())&&userCoupon.getEndTime().after(start)){
                if(userCoupon.getEndTime().after(start)){
                    Calendar endDate = Calendar.getInstance();
                    endDate.setTime(userCoupon.getEndTime());
                    endDate.add(endDate.DAY_OF_MONTH,1);
                    start = endDate.getTime();
                }
            }
        }

        UserCoupon coupon = new UserCoupon();
        coupon.setUserId(userId);
        coupon.setType(UserCouponType.MonthlyTicket.ordinal());
        coupon.setStartTime(start);

        Calendar startDate = Calendar.getInstance();
        startDate.setTime(start);
        startDate.add(startDate.MONTH, 1);
        coupon.setEndTime(startDate.getTime());
        coupon.setImage(image);
        coupon.setContent(content);
        int res = _rootRepository.insertItem(coupon);
        if(res>0){
            return true;
        }else{
            return false;
        }
    }

    public boolean addYearlyTicketTicket(long userId,Date start,String image,String content)
    {
        List<UserCoupon>  userCoupons = getUserTimePeriodTicketCoupons(userId);
        if(userCoupons!=null){
            for (UserCoupon userCoupon:userCoupons){
                //if(userCoupon.getType().equals(UserCouponType.YearlyTicket.ordinal())&&userCoupon.getEndTime().after(start)){
                if(userCoupon.getEndTime().after(start)){
                    Calendar endDate = Calendar.getInstance();
                    endDate.setTime(userCoupon.getEndTime());
                    endDate.add(endDate.DAY_OF_YEAR,1);
                    start = endDate.getTime();
                }
            }
        }

        UserCoupon coupon = new UserCoupon();
        coupon.setUserId(userId);
        coupon.setType(UserCouponType.YearlyTicket.ordinal());
        coupon.setStartTime(start);

        Calendar startDate = Calendar.getInstance();
        startDate.setTime(start);
        startDate.add(startDate.YEAR, 1);
        coupon.setEndTime(startDate.getTime());
        coupon.setImage(image);
        coupon.setContent(content);
        int res = _rootRepository.insertItem(coupon);
        if(res>0){
            return true;
        }else{
            return false;
        }
    }


    private List<UserCoupon> getUserTimePeriodTicketCoupons(long userId)
    {
        ISpecification specification = new UserCouponUserIdSpecification(userId);
        List<UserCoupon> userCouponList = _rootRepository.getList(specification);
        return userCouponList;
    }
}
