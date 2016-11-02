package net.bus.web.service;

import net.bus.web.model.Activity;
import net.bus.web.model.User;
import net.bus.web.service.exception.OutOfStockException;
import net.bus.web.service.exception.RepeatApplyException;

import java.util.List;

/**
 * Created by sky on 16/10/13.
 */
public interface IActivityService {

    List<Activity> getAllActivity(int page,int limit);

    int getAllActivityCount();

    Activity getActivityDetails(Long id);

    boolean addActivity(Activity activity);

    boolean deleteActivity(Long id);

    String join(Long id, User user) throws OutOfStockException, RepeatApplyException;

    boolean updateActivity(Activity activity);
}
