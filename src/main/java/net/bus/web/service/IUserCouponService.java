package net.bus.web.service;

import net.bus.web.model.UserCoupon;
import net.bus.web.model.type.UserCouponType;

import java.util.Date;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-08-04.
 */
public interface IUserCouponService {

    List<Long> getMonthlyTicketUserIdList();

    List<Long> getYearlyTicketUserIdList();

    UserCoupon getUserTimePeriodTicketCoupon(long userId);

    boolean addMonthlyTicket(long userId,Date start,String image,String content);

    boolean addYearlyTicketTicket(long userId,Date start,String image,String content);
}
