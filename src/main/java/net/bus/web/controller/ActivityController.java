package net.bus.web.controller;


import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.common.Util;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.*;
import net.bus.web.enums.OrderTypeEnum;
import net.bus.web.model.Activity;
import net.bus.web.model.Pojo.AlipayOrderCallBack;
import net.bus.web.model.Pojo.PagePojo;
import net.bus.web.model.User;
import net.bus.web.service.IActivityService;
import net.bus.web.service.exception.ActivityException;
import net.bus.web.service.exception.OutOfStockException;
import net.bus.web.service.exception.RepeatApplyException;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    public IResult all(@ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "0")int page,
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
        disItem.setDetail(activity.getDetail());
        disItem.setPrice(activity.getPrice());
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
            disItem.setDetail(activity.getDetail());
            disItem.setPrice(activity.getPrice());
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
    public IResult join(@ApiParam(required = true, name = "id", value = "id")
                             @RequestBody(required = true) ActivityJoin request){
        //TODO 参加活动逻辑
        BaseResult result = new BaseResult();
        User user = (User) session.getAttribute(SessionContext.CURRENT_USER);
        try {
            OrderTypeEnum orderType = request.getOrder_type()==0?OrderTypeEnum.ALIPAY:OrderTypeEnum.get(request.getOrder_type());
            //TODO 暂时根据支付宝请求返回结果,后跟前端协调修改dto后支持微信支付
            String sign = ((AlipayOrderCallBack)_activityService.join(orderType,request.getId(),user)).getSign();
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


    @Auth(role = Auth.Role.USER)
    @RequestMapping(value="/list", method = RequestMethod.GET)
    @ApiOperation(value = "活动列表页面", httpMethod = "GET", response = ModelAndView.class, notes = "活动列表页面")
    @ResponseBody
    public ModelAndView list(@ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "0")int page,
                             @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "10")int limit,
                             HttpServletRequest request, Model model)
    {
        logger.info("url:/activity/list");
        HttpSession session=request.getSession();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("activity_list");
        List<Activity> activities = _activityService.getAllActivity(page,limit);
        PagePojo pagePojo = new PagePojo(_activityService.getAllActivityCount(),limit,page);
        mv.addObject("activityList",activities);
        session.setAttribute("pagePojo",pagePojo);
        return mv;
    }

    @Auth(role=Auth.Role.USER)
    @RequestMapping(value = "/addactivity",method = RequestMethod.POST)
    @ApiOperation(value = "添加活动",httpMethod = "POST",response = BaseResult.class,notes = "添加活动")
    @ResponseBody
    public  BaseResult AddActivity(@ApiParam(required = true, name = "addactivity", value = "添加活动请求")
                                     @RequestBody   Activity activity

    )  {
        logger.info("url:/activity/addactivity");
        BaseResult result=new BaseResult();
        if(_activityService.addActivity(activity)){
            result.setResult("success");
            result.setContent("添加成功!");
        }else{
            result.setResult("failure");
            result.setContent("添加失败!");
        }

           return result;


    }

    @Auth(role=Auth.Role.USER)
    @RequestMapping(value = "/del",method = RequestMethod.DELETE)
    @ApiOperation(value = "批量删除活动",httpMethod = "POST",response = BaseResult.class,notes = "批量删除活动")
    @ResponseBody
    public BaseResult Del(@ApiParam(required = true, name = "del", value = "批量删除活动") @RequestBody BaseRequest request)
    {
        logger.info("url:/activity/del");
        BaseResult result=new BaseResult();
        List<Long> ids =request.getIds();
        if(_activityService.delete(ids)){
            result.setResult("success");
            result.setContent("删除成功");
        }else{
            result.setResult("failure");
            result.setContent("删除失败");
        }
        return result;
    }



    @Auth(role=Auth.Role.USER)
    @RequestMapping(value = "/updateactivity",method = RequestMethod.POST)
    @ApiOperation(value = "修改活动",httpMethod = "POST",response = BaseResult.class,notes = "修改活动")
    @ResponseBody
    public BaseResult UpdateActivity(@ApiParam(required = true, name = "updateactivity", value = "修改活动请求")
                                           @RequestBody Activity activity

    ) {
        logger.info("url:/activity/updateactivity");
        BaseResult result=new BaseResult();
        if(_activityService.updateActivity(activity)){
            result.setResult("success");
            result.setContent("修改成功!");
        }else {
            result.setResult("failure");
            result.setContent("修改失败!");
        }
        return result;
    }

    @Auth(role=Auth.Role.USER)
    @RequestMapping(value="/joinActivity" ,method=RequestMethod.POST)
    @ApiOperation(value = "参加活动人信息",httpMethod = "POST",response = BaseResult.class,notes="参加活动人信息")
    @ResponseBody
    public BaseResult JoinActivity(@ApiParam(required=true,name="joinActivity",value = "参加活动人信息")
                                   @RequestBody    Applicants applicants

                                   )
    {
        logger.info("url:/activity/joinActivity");
        BaseResult result=new BaseResult();
        result.setResult("success");
        return  result;
    }



}
