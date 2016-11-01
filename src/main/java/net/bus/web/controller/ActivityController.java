package net.bus.web.controller;


import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.common.Util;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.*;
import net.bus.web.model.Activity;
import net.bus.web.model.User;
import net.bus.web.service.IActivityService;
import net.bus.web.service.exception.ActivityException;
import net.bus.web.service.exception.OutOfStockException;
import net.bus.web.service.exception.RepeatApplyException;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by sky on 16/10/13.
 */

@Controller
@RequestMapping("/activity")
public class ActivityController {

    //@Autowired
    @Resource(name = "activityService")
    private IActivityService _activityService;

    private Logger logger = Logger.getLogger(this.getClass().getName());


    @Autowired
    private HttpSession session;

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
    @ApiOperation(value = "获取活动详细", httpMethod = "GET", response = ActivityItem.class, notes = "获取活动详细")
    public IResult detail(
            @ApiParam(required = true, name = "id", value = "id")
            @RequestParam(value = "id", required = true, defaultValue = "0")long id
    )
    {
        logger.info("activity detail");
        ActivityItem disItem = new ActivityItem();
        Activity activity = _activityService.getActivityDetails(id);
        disItem.setId(activity.getId());
        disItem.setImg(activity.getImage());
        disItem.setTitle(activity.getTitle());
        disItem.setDetial(activity.getDetail());
        disItem.setStart_time(activity.getStartime());
        disItem.setEnd_time(activity.getEndtime());
        disItem.setLower_limit(activity.getLowerLimit());
        disItem.setUpper_limit(activity.getUpperLimit());
        disItem.setRemain(Util.daysBetween(new Date(),activity.getStartime()));  //剩余时间
        disItem.setNumber_of_people(activity.getNumberOfPeople());
        return disItem;
    }


    private List<ActivityItem> getDisplayList(List<Activity> activityList)
    {
        List<ActivityItem> displayList = new ArrayList<ActivityItem>();
        for (Activity activity : activityList) {
            ActivityItem disItem = new ActivityItem();
            disItem.setId(activity.getId());
            disItem.setImg(activity.getImage());
            disItem.setTitle(activity.getTitle());
            disItem.setDetial(activity.getDetail());
            disItem.setStart_time(activity.getStartime());
            disItem.setEnd_time(activity.getEndtime());
            disItem.setLower_limit(activity.getLowerLimit());
            disItem.setUpper_limit(activity.getUpperLimit());
            disItem.setRemain(Util.daysBetween(new Date(),activity.getStartime()));  //剩余时间
            disItem.setNumber_of_people(activity.getNumberOfPeople());
            displayList.add(disItem);
        }
        return displayList;
    }

    @Auth(role = Auth.Role.USER)
    @RequestMapping(value = "/join",method = RequestMethod.POST)
    @ApiOperation(value = "参加活动", httpMethod = "POST", response = BaseResult.class, notes = "获取活动详细")
    @ResponseBody
    public IResult join(@ApiParam(required = true, name = "活动id", value = "id")
                             @RequestParam(value = "id", required = true, defaultValue = "0")long id){
        //TODO 参加活动逻辑
        BaseResult result = new BaseResult();
        User user = (User) session.getAttribute(SessionContext.CURRENT_USER);
        try {
            String sign = _activityService.join(id,user);
            if(!StringUtils.isBlank(sign)){
                result.setContent(sign);
                result.setResult("success");

            }else{
                result.setResult("failure");
            }
            return result;
        } catch (OutOfStockException e) {
            //商品已售完
            result.setResult("failed");
            result.setContent(e.getMessage());
        } catch (RepeatApplyException e) {
            //重复下单
            result.setResult("error");
            result.setError(e.getMessage());

        }catch (ActivityException e){
            //活动时间错误
            result.setResult("error");
            result.setError(e.getMessage());
        }
        return result;
    }


}
