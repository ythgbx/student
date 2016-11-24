package net.bus.web.service.impl;

import net.bus.web.common.AES;
import net.bus.web.controller.dto.TicketBuyItem;
import net.bus.web.model.*;
import net.bus.web.model.Pojo.UserCheckPojo;
import net.bus.web.model.type.PointRecordType;
import net.bus.web.model.type.PointSourceType;
import net.bus.web.repository.ISpecification;
import net.bus.web.repository.UserTicketRepository;
import net.bus.web.repository.specification.UserTicketIdSpecification;
import net.bus.web.repository.specification.UserTicketLineIdSpecification;
import net.bus.web.repository.specification.UserTicketUserIdSpecification;
import net.bus.web.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-04.
 */
@Service
public class UserTicketService implements IUserTicketService {

    @Autowired
    private UserTicketRepository _rootRepository;
    @Autowired
    private ILineService _lineService;
    @Autowired
    private IUserService _userService;
    @Autowired
    private IBusService _busService;
    @Autowired
    private IPointRecordService _pointRecordService;
    @Autowired
    private IStationService _stationService;

    public List<UserTicket> getTickets(long user_id,int page,int limit)
    {
        Calendar checkRange = Calendar.getInstance();
        checkRange.setTime(new Date());
        checkRange.add(Calendar.MINUTE, -15);
        ISpecification specification = new UserTicketUserIdSpecification(user_id);
        return _rootRepository.getList(specification, page - 1, limit);
    }

    public UserTicket getDetail(long id)
    {
        return _rootRepository.getItem(new UserTicketIdSpecification(id));
    }

    public UserTicket getTicketByLineId(long line_id)
    {
        UserTicket ticket = _rootRepository.getItem(new UserTicketLineIdSpecification(line_id));
        return  ticket;
    }

    @Transactional
    public boolean buyTicket(long line_id,User user) throws RuntimeException {
        //TODO 需要新增事务控制购票过程
        Line line = _lineService.getLineDetails(line_id);
        if(line!=null){

            //TODO 负值是否仍需范围内限定,可设置于sys.properties内
//            //由于弱联网检票需要废弃该代码 允许少量负值 20160803
//            //当不够积分支付时,返回
//            if(user.getPoints()<line.getPrice()){
//                return false;
//            }

            UserTicket userTicket = new UserTicket();
            userTicket.setLineId(line_id);
            userTicket.setUserId(user.getId());
            userTicket.setPrice(line.getPrice());

            user.setPoints(user.getPoints() - userTicket.getPrice());

            _rootRepository.insertItem(userTicket);
            _userService.updateUser(user);

            return true;
        }
        return  false;
    }

    @Transactional
    public boolean buyTicket(long line_id,long user_id){
        return buyTicket(line_id,_userService.getUser(user_id));
    }

    @Transactional
    public boolean buyTicket(long line_id,long user_id,long start_station_id,long end_station_id){
        Line line = _lineService.getLineDetails(line_id);
        User user = _userService.getUser(user_id);
        if(line!=null&&user!=null){

            //TODO 负值是否仍需范围内限定,可设置于sys.properties内
//            //由于弱联网检票需要废弃该代码 允许少量负值 20160803
//            //当不够积分支付时,返回
//            if(user.getPoints()<line.getPrice()){
//                return false;
//            }

            Station startStation = _stationService.getDetails(start_station_id);
            Station endStation = _stationService.getDetails(end_station_id);
            UserTicket userTicket = new UserTicket();
            userTicket.setLineId(line_id);
            userTicket.setUserId(user.getId());
            userTicket.setPrice((endStation.getPrice().subtract(startStation.getPrice())).abs().intValue());

            user.setPoints(user.getPoints() - userTicket.getPrice());

            _rootRepository.insertItem(userTicket);
            _userService.updateUser(user);

            return true;
        }
        return  false;
    }

    @Transactional
    public boolean buyTickets(String device,List<TicketBuyItem> userTickets) throws Exception
    {
        if(!StringUtils.isBlank(device)){
            Bus bus = _busService.getBus(null,device);
            if (bus != null) {
                if(bus.getLineId()>0){
                    Line line = _lineService.getLineDetails(bus.getLineId());
                    if(line!=null){
                        for(TicketBuyItem ticketBuyItem:userTickets){
                            //TODO 解密user_check获取user_id与check_date
                            UserCheckPojo checkPojo = getUserCheckPojo(ticketBuyItem.getUser_check());
                            User user = _userService.getUser(checkPojo.getId());
                            if(user!=null){
                                UserTicket userTicket = new UserTicket();
                                userTicket.setLineId(line.getId());
                                userTicket.setUserId(user.getId());
                                userTicket.setPrice(line.getPrice());
                                userTicket.setTime(new Date(checkPojo.getTimestamp()*1000));

                                user.setPoints(user.getPoints() - line.getPrice());

                                _rootRepository.insertItem(userTicket);
                                _userService.updateUser(user);
                                _pointRecordService.recordPoint(user.getId(), PointRecordType.Expend, PointSourceType.TICKET, line.getPrice(), line.getName());
                            }
                        }
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * convert encode string to UserCheckPojo
     * @param userCheck encode string
     * @return UserCheckPojo
     * @throws Exception some AES decode or encode error
     */
    public UserCheckPojo getUserCheckPojo(String userCheck) throws Exception {
        String check = AES.getAesInstance().Decrypt(userCheck);    //decode string and get username&timestamp
        String [] infoArr = check.split("&");
        UserCheckPojo checkPojo = new UserCheckPojo();
        checkPojo.setId(Long.parseLong(infoArr[0]));
        checkPojo.setTimestamp(Long.parseLong(infoArr[1]));
        return checkPojo;
    }

    public int getTicketsCount(long user_id)
    {
        ISpecification specification = new UserTicketUserIdSpecification(user_id);
        return _rootRepository.count(specification);
    }
}
