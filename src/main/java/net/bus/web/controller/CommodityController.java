package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.*;
import net.bus.web.model.Commodity;
import net.bus.web.model.CommodityOrder;
import net.bus.web.model.CommodityOrderExample;
import net.bus.web.model.Pojo.PagePojo;
import net.bus.web.model.User;
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
    @ApiOperation(value = "商品列表页面", httpMethod = "GET", response = ModelAndView.class, notes = "商品列表页面")
    public ModelAndView list(@ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "0")int page,
                             @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "10")int limit,
                             HttpServletRequest request, Model model)
    {
        logger.info("url:/commodity/list");
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("commodity_list");

        List<Commodity> commodityList= _commodityService.getAll(page, limit);
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
        List<Commodity> list = _commodityService.getAll(page, limit);
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
        Commodity commodity = _commodityService.getDetails(id);
        commodityDetail.setId(commodity.getId());
        commodityDetail.setName(commodity.getName());
        commodityDetail.setDepict(commodity.getDepict());
        commodityDetail.setPoint(commodity.getPoint());
        commodityDetail.setImg(commodity.getImg());
        commodityDetail.setPrice(commodity.getPrice());
        return commodityDetail;
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    @ApiOperation(value = "购买商品", httpMethod = "POST", response = BaseResult.class, notes = "购买商品")
    public IResult detail(@ApiParam(required = true, name = "request", value = "购买商品请求")@RequestBody CommodityBuy request)
    {
        BaseResult result = new BaseResult();
        User currentUser = (User) session.getAttribute(SessionContext.CURRENT_USER);
        String sign = _commodityService.buy(request.getId(),currentUser);
        if(!StringUtils.isBlank(sign)){
            result.setContent(sign);
            result.setResult("success");

        }else{
            result.setResult("failure");
        }
        return result;
    }


    /**

     * 用户订单查询界面
     * @param model
     * @return
     */
    @Auth(role = Auth.Role.USER)
    @RequestMapping(value="/orderList", method = RequestMethod.GET)
    @ApiOperation(value = "用户订单列表页面", httpMethod = "GET", response = ModelAndView.class, notes = "用户订单列表页面")
    public ModelAndView orderList(@ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "0")int page,
                                  @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "10")int limit,
            HttpServletRequest request,Model model)
    {
        logger.info("url:/commodity/orderList");
        System.out.println(page+"aaa");
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();

        List<CommodityOrder> commodityOrders= _commodityService.getAllOrers(page,limit);
        mv.addObject("commodityOrders",commodityOrders);
        PagePojo pagePojo = new PagePojo(_commodityService.getAllOrderCount(),limit,page);
        session.setAttribute("pagePojo",pagePojo);
        mv.setViewName("user_orderList");
        return mv;
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
        List<CommodityOrder> commodityOrders = _commodityService.getUserOrders(currentUser.getId(), page, limit);
        commodityOrderList.setCommoditys(getOrderDisplayList(commodityOrders));
        commodityOrderList.setPage(page);
        commodityOrderList.setTotal_count(_commodityService.getUserOrdersCount(currentUser.getId()));
        return commodityOrderList;
    }


    private List<CommodityItem> getDisplayList(List<Commodity> commodityList)
    {
        List<CommodityItem> displayList = new ArrayList<CommodityItem>();
        for(Commodity commodity:commodityList){
            CommodityItem commodityItem = new CommodityItem();
            commodityItem.setId(commodity.getId());
            commodityItem.setName(commodity.getName());
            commodityItem.setDepict(commodity.getDepict());
            commodityItem.setPrice(commodity.getPrice());
            commodityItem.setImg(commodity.getItemImg());
            displayList.add(commodityItem);
        }
        return displayList;
    }

    private List<CommodityOrderItem> getOrderDisplayList(List<CommodityOrder> commodityOrderList)
    {
        List<CommodityOrderItem> displayList = new ArrayList<CommodityOrderItem>();

        List<Long> commodityIds = new ArrayList<Long>();
        for(CommodityOrder commodityOrder:commodityOrderList){
            commodityIds.add(commodityOrder.getCommodityId());
        }
        if(commodityIds.size()==0)
            return displayList;

        List<Commodity> commodities = _commodityService.getList(commodityIds);
        HashMap<Long,Commodity> commodityMaps = new HashMap<Long, Commodity>();
        for (Commodity commodity:commodities){
            commodityMaps.put(commodity.getId(),commodity);
        }

        for(CommodityOrder commodityOrder:commodityOrderList){
            CommodityOrderItem commodityOrderItem = new CommodityOrderItem();
            commodityOrderItem.setId(commodityOrder.getId());
            commodityOrderItem.setName(commodityMaps.get(commodityOrder.getCommodityId()).getName());
            commodityOrderItem.setImg(commodityMaps.get(commodityOrder.getCommodityId()).getItemImg());
            commodityOrderItem.setTotal(commodityOrder.getPay());
            commodityOrderItem.setCreateTime(commodityOrder.getCreateTime().getTime());
            commodityOrderItem.setPayTime(commodityOrder.getPayTime().getTime());

            displayList.add(commodityOrderItem);
        }
        return displayList;
    }
}
