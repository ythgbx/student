package net.bus.web.service;

import net.bus.web.model.Activity;

import java.util.List;

/**
 * Created by sky on 16/10/13.
 */
public interface IActivityService {

    List<Activity> getAllActivity(int page,int limit);

    int getAllActivityCount();

    Activity getActivityDetails(Long id);

    boolean addActivity(Activity activity);

}
