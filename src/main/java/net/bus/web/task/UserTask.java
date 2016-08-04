package net.bus.web.task;

import net.bus.web.model.User;
import net.bus.web.service.IUserCouponService;
import net.bus.web.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-08-04.
 */
public class UserTask {

    private static Logger logger = LoggerFactory.getLogger(UserTask.class);

    @Autowired
    private IUserService service;
    @Autowired
    private IUserCouponService couponService;

    @Value("#{sysProperties['monthlyTicketUserAddPoint']}")
    private Integer _monthlyTicketUserAddPoint;
    /**
     * 定期任务处理
     */
    public void doBiz() {
        logger.info("do user task");
        MonthlyTicketUserHandle();
    }

    private void MonthlyTicketUserHandle()
    {
        List<Long> userIds = couponService.getMonthlyTicketUserIdList();
        List<User> list = service.getUsers(userIds);
        for(User user:list){
            service.addPoint(user,_monthlyTicketUserAddPoint);//设置月卡补充积分数量
        }
    }
}
