package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.common.config.RString;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.*;
import net.bus.web.enums.OrderTypeEnum;
import net.bus.web.model.*;
import net.bus.web.model.Commodity;
import net.bus.web.model.Pojo.OrderCallBack;
import net.bus.web.model.Pojo.PagePojo;
import net.bus.web.service.ICommodityService;
import org.apache.commons.lang.StringUtils;
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
import java.util.HashMap;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-09-04.
 */
@Controller
@RequestMapping("/commodity")
public class CommodityController {

    //region restfull接口部分
    //@Autowired
    //@Qualifier("commodityService")
    @Resource(name = "commodityService")
    private ICommodityService _commodityService;
    @Autowired
    private HttpSession session;

    private Logger logger = Logger.getLogger(this.getClass().getName());


    /**
     * 商品信息查询
     * @param model
     * @return
     */
    @Auth(role = Auth.Role.USER)
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public ModelAndView list(@ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "1")int page,
                             @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "10")int limit,
                             HttpServletRequest request, Model model)
    {
        logger.info("url:/commodity/list");
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("commodity_list");

        List<net.bus.web.model.Commodity> commodityList= _commodityService.getAll(page, limit);
        PagePojo pagePojo = new PagePojo(_commodityService.getAllCount(),limit,page);
        mv.addObject("commodityLists",commodityList);
        session.setAttribute("pagePojo",pagePojo);
        return mv;
    }


    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/list/all", method = RequestMethod.GET)
    @ApiOperation(value = "获取商品列表", httpMethod = "GET", response = CommodityList.class, notes = "获取商品列表")
    public IResult all(@ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "1")int page,
                       @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "5")int limit)
    {
        CommodityList commodityList = new  CommodityList();
        List<net.bus.web.model.Commodity> list = _commodityService.getAll(page, limit);
        commodityList.setCommoditys(getDisplayList(list));
        commodityList.setPage(page);
        commodityList.setTotal_count(_commodityService.getAllCount());
        return commodityList;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ApiOperation(value = "获取商品详细", httpMethod = "GET", response = CommodityDetail.class, notes = "获取商品详细")
    public IResult detail(@ApiParam(required = true, name = "id", value = "id")@RequestParam(value = "id", required = true, defaultValue = "0")long id)
    {
        CommodityDetail commodityDetail = new CommodityDetail();
        net.bus.web.model.Commodity commodity = _commodityService.getDetails(id);
        commodityDetail.setId(commodity.getId());
        commodityDetail.setName(commodity.getName());
        commodityDetail.setDepict(commodity.getDepict());
        commodityDetail.setPrice(commodity.getPrice());
        commodityDetail.setAmount(commodity.getAmount());
        commodityDetail.setItemImg(commodity.getItemImg());
        commodityDetail.setImg(commodity.getImg());
        commodityDetail.setPoint(commodity.getPoint());
        commodityDetail.setCouponType(commodity.getCouponType());
        commodityDetail.setTypeId(commodity.getTypeId());
        commodityDetail.setFlag(commodity.getFlag());
        return commodityDetail;
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    @ApiOperation(value = "购买商品", httpMethod = "POST", response = BaseResult.class, notes = "购买商品")
    public IResult detail(@ApiParam(required = true, name = "request", value = "购买商品请求")@RequestBody CommodityBuy request)
    {
        OrderBack result = new OrderBack();
        User currentUser = (User) session.getAttribute(SessionContext.CURRENT_USER);
        OrderTypeEnum orderType = request.getOrder_type()==0? OrderTypeEnum.ALIPAY:OrderTypeEnum.get(request.getOrder_type());
        //TODO 暂时根据支付宝请求返回结果,后跟前端协调修改dto后支持微信支付
        /*String sign = ((AlipayOrderCallBack)_commodityService.buy(orderType,request.getId(),currentUser)).getSign();
        if(!StringUtils.isBlank(sign)){
            result.setContent(sign);
            result.setResult("success");

        }else{
            result.setResult("failure");
        }
        return result;*/
        OrderCallBack orderCallBack = _commodityService.buy(orderType,request.getId(),currentUser);
        if(orderCallBack!=null&&StringUtils.isBlank(orderCallBack.getFailed())){
            result.setPayinfo(orderCallBack);
            result.setResult("success");
        }else{
            result.setResult("failure");
        }
        return result;
    }



    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    @ApiOperation(value = "用户商品订单", httpMethod = "GET", response = CommodityOrderList.class, notes = "用户商品订单")
    public IResult order(@ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "1")int page,
                         @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "5")int limit)
    {
        CommodityOrderList commodityOrderList = new CommodityOrderList();
        User currentUser = (User) session.getAttribute(SessionContext.CURRENT_USER);
        List<Orders> commodityOrders = _commodityService.getUserOrders(currentUser.getId(), limit, page);
        commodityOrderList.setCommoditys(getOrderDisplayList(commodityOrders));
        commodityOrderList.setPage(page);
        commodityOrderList.setTotal_count(_commodityService.getUserOrdersCount(currentUser.getId()));
        return commodityOrderList;
    }


    private List<CommodityItem> getDisplayList(List<net.bus.web.model.Commodity> commodityList)
    {
        List<CommodityItem> displayList = new ArrayList<CommodityItem>();
        for(net.bus.web.model.Commodity commodity:commodityList){
            CommodityItem commodityItem = new CommodityItem();
            commodityItem.setId(commodity.getId());
            commodityItem.setName(commodity.getName());
            commodityItem.setDepict(commodity.getDepict());
            commodityItem.setPrice(commodity.getPrice());
            commodityItem.setItemImg(commodity.getItemImg());
            displayList.add(commodityItem);
        }
        return displayList;
    }

    private List<CommodityOrderItem> getOrderDisplayList(List<Orders> commodityOrderList)
    {
        List<CommodityOrderItem> displayList = new ArrayList<CommodityOrderItem>();

        List<Long> commodityIds = new ArrayList<Long>();
        for(Orders commodityOrder:commodityOrderList){
            commodityIds.add(commodityOrder.getProductId());
        }
        if(commodityIds.size()==0)
            return displayList;

        List<Commodity> commodities = _commodityService.getList(commodityIds);
        HashMap<Long,Commodity> commodityMaps = new HashMap<Long, Commodity>();
        for (Commodity commodity:commodities){
            commodityMaps.put(commodity.getId(),commodity);
        }

        for(Orders commodityOrder:commodityOrderList){
            CommodityOrderItem commodityOrderItem = new CommodityOrderItem();
            commodityOrderItem.setId(commodityOrder.getId());
            if(commodityMaps.containsKey((commodityOrder.getProductId()))){
                commodityOrderItem.setName(commodityMaps.get(commodityOrder.getProductId()).getName());
                commodityOrderItem.setImg(commodityMaps.get(commodityOrder.getProductId()).getItemImg());
            }else{
                commodityOrderItem.setName(RString.COMMODITY_NOT_FOUND);
                commodityOrderItem.setImg("");
            }

            commodityOrderItem.setTotal(commodityOrder.getPay());
            commodityOrderItem.setCreateTime(commodityOrder.getCreateTime().getTime());
            commodityOrderItem.setPayTime(commodityOrder.getPayTime().getTime());

            displayList.add(commodityOrderItem);
        }
        return displayList;
    }
    //endregion


    //region 网页后台管理部分


    /**
     * 用户订单查询界面
     * @return
     */
    @Auth(role = Auth.Role.USER)
    @RequestMapping(value="/orderList", method = RequestMethod.GET)
    public ModelAndView orderList(@ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "1")int page,
                                  @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "10")int limit,
                                  HttpServletRequest request)
    {
        logger.info("url:/commodity/orderList");
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();

        List<Orders> orders= _commodityService.getAllOrders(page,limit);
        mv.addObject("orders",orders);
        PagePojo pagePojo = new PagePojo(_commodityService.getAllOrderCount(),limit,page);
        session.setAttribute("pagePojo",pagePojo);
        mv.setViewName("user_orderList");
        return mv;
    }

    /**
     * 商品添加
     * @param commodity
     * @return
     */
    @Auth(role=Auth.Role.USER)
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation(value = "添加商品",hidden = true)
    @ResponseBody
    public BaseResult addCommodity(@RequestBody Commodity commodity){

        logger.info("url:/commodity/add");
        BaseResult result = new BaseResult();
        if (_commodityService.add(commodity)) {
            result.setResult("success");
            result.setContent("添加成功");
        }else {
            result.setResult("failure");
            result.setContent("添加失败");
        }
        return result;
    }

    /**
     * 商品修改
     * @param commodity
     * @return
     */
    @Auth(role=Auth.Role.USER)
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation(value = "修改商品",hidden = true)
    @ResponseBody
    public BaseResult updateCommodity(@RequestBody Commodity commodity){

        logger.info("url:/commodity/update");
        BaseResult result = new BaseResult();
        if(_commodityService.update(commodity)){
            result.setResult("success");
            result.setContent("修改过成功!");
        }else {
            result.setResult("error");
            result.setContent("修改失败!");
        }
        return result;
    }

    /**
     * 商品删除操作(支持批量删除)
     * @param request
     * @return
     */
    @RequestMapping(value="/del", method = RequestMethod.DELETE)
    @ApiOperation(value = "批量删除商品", httpMethod = "POST", response = BaseResult.class, notes = "批量删除商品")
    @ResponseBody
    public BaseResult delCommodity(@ApiParam(required = true, name = "request", value = "商品编号列表")
                                   @RequestBody BaseRequest request)
    {
        BaseResult result = new BaseResult();
        List<Long> ids = request.getIds();
        result.setResult("success");
        if(ids !=null && ids.size()> 0){
            if(_commodityService.del(ids)){
                result.setContent("删除成功");
            }else{
                result.setResult("failure");
                result.setContent("删除失败");
            }
        }else{
            result.setContent("您没有选中任何项");
        }
        return result;
    }

}
