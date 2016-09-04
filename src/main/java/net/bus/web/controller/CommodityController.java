package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.controller.dto.CommodityDetail;
import net.bus.web.controller.dto.CommodityItem;
import net.bus.web.controller.dto.CommodityList;
import net.bus.web.controller.dto.IResult;
import net.bus.web.model.Commodity;
import net.bus.web.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-09-04.
 */
@Controller
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private ICommodityService _commodityService;

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/list/all", method = RequestMethod.GET)
    @ApiOperation(value = "获取全部商品", httpMethod = "GET", response = CommodityList.class, notes = "获取全部商品")
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


    private List<CommodityItem> getDisplayList(List<Commodity> commodityList)
    {
        List<CommodityItem> displayList = new ArrayList<CommodityItem>();
        for(Commodity commodity:commodityList){
            CommodityItem commodityItem = new CommodityItem();
            commodityItem.setId(commodity.getId());
            commodityItem.setName(commodity.getName());
            commodityItem.setDepict(commodity.getDepict());
            commodityItem.setPrice(commodity.getPrice());
            commodityItem.setImg(commodity.getImg());
            displayList.add(commodityItem);
        }
        return displayList;
    }
}
