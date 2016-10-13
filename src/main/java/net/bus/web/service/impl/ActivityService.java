package net.bus.web.service.impl;

import net.bus.web.model.Activity;
import net.bus.web.repository.ActivityRepository;
import net.bus.web.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sky on 16/10/13.
 */

@Service
public class ActivityService implements IActivityService{
    @Autowired
    private ActivityRepository _rootRepository;

    public List<Activity> getAllActivity(int page,int limit){
        return _rootRepository.getAll(page-1,limit);
    }

    public int getAllActivityCount(){
        return _rootRepository.count();
    }

    public Activity getActivityDetails(Long id){
        return _rootRepository.getItem(id);
    }

    public boolean addActivity(Activity activity){
        return false;
    }

}
