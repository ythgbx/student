package net.bus.web.controller;


import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.controller.dto.IResult;
import net.bus.web.controller.dto.ActivityDetail;
import net.bus.web.controller.dto.ActivityItem;
import net.bus.web.controller.dto.ActivityList;
import net.bus.web.model.Activity;
import net.bus.web.service.IActivityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by sky on 16/10/13.
 */

@Controller
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private IActivityService _activityService;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/list/all",method = RequestMethod.GET)
    @ApiOperation(value = "获取全部活动", httpMethod = "GET", response = ActivityList.class, notes="获取全部活动")
    public IResult all(@ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "1")int page,
                       @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "5")int limit)
    {
        logger.info("activity all query");
        ActivityList activityList = new ActivityList();
        activityList.setActivity(getDisplayList(_activityService.getAllActivity(page,limit)));
        activityList.setPage(page);
        activityList.setTotal_count(_activityService.getAllActivityCount());
        return activityList;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ApiOperation(value = "获取活动详细", httpMethod = "GET", response = ActivityDetail.class, notes = "获取活动详细")
    public IResult detail(@ApiParam(required = true, name = "id", value = "id")@RequestParam(value = "id", required = true, defaultValue = "0")long id)
    {
        logger.info("activity detail");
        ActivityDetail activityDetail = new ActivityDetail();
        Activity activity = _activityService.getActivityDetails(id);
        activityDetail.setId(activity.getId());
        activityDetail.setContent(activity.getContent());
        activityDetail.setImg(activity.getImage());
        activityDetail.setTime(activity.getTime().getTime());
        activityDetail.setIntroduction(activity.getIntroduction());
        activityDetail.setScope(activity.getScope());
        return activityDetail;
    }


    private List<ActivityItem> getDisplayList(List<Activity> activityList)
    {
        List<ActivityItem> displayList = new ArrayList<ActivityItem>();
        for (Activity activity : activityList) {
            ActivityItem disItem = new ActivityItem();
            disItem.setId(activity.getId());
            disItem.setImg(activity.getImage());
            displayList.add(disItem);
        }
        return displayList;
    }
}
