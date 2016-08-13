package net.bus.web.service;

import net.bus.web.model.UserCoupon;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-08-04.
 */
public interface IUserCouponService {

    List<Long> getMonthlyTicketUserIdList();

    List<Long> getYearlyTicketUserIdList();

    UserCoupon getUserTimePeriodTicketCoupon(long userId);
}
