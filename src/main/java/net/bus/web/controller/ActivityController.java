package net.bus.web.controller;


import com.sun.org.apache.regexp.internal.RE;
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
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
            _activityService.join(id,user);
            result.setResult("success");
            result.setContent("您已成功报名参加本次活动");
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


    @Auth(role = Auth.Role.USER)
    @RequestMapping(value="/list", method = RequestMethod.GET)
    @ApiOperation(value = "活动列表页面", httpMethod = "GET", response = ModelAndView.class, notes = "活动列表页面")
    @ResponseBody
    public ModelAndView list(Model model)
    {
        logger.info("url:/activity/list");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("activity");
        List<Activity> activities = _activityService.getAllActivity(1,10);
        mv.addObject("activityList",activities);
        return mv;
    }

    @Auth(role=Auth.Role.USER)
    @RequestMapping(value = "/addactivity",method = RequestMethod.POST)
    @ApiOperation(value = "添加活动",httpMethod = "POST",response = BaseResult.class,notes = "添加活动")
    @ResponseBody
    public  ModelAndView AddActivity(@ApiParam(required = true, name = "addactivity", value = "添加活动请求")
                               @Param("title") String title,
                               @Param("detail") String detail,
                               @Param("amount") Integer amount,
                               @Param("price") BigDecimal price,
                               @Param("startime") String startime,
                               @Param("endtime") String endtime



    ) throws ParseException {
        logger.info("url:/activity/addactivity");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startime2 = dateFormat.parse(startime);
        Date endtime2 = dateFormat.parse(endtime);
        Activity activity=new Activity();
        activity.setTitle(title);
        activity.setDetail(detail);
        activity.setAmount(amount);
        activity.setPrice(price);
        activity.setStartime(startime2);
        activity.setEndtime(endtime2);
        activity.setImage("");
        if (title != null) {
            if (_activityService.addActivity(activity)) {
                return new ModelAndView("redirect:/activity/list");
            }
            return new ModelAndView("redirect:/activity/list");
        }
        return new ModelAndView("redirect:/activity/list");


    }

}
