package net.bus.web.service.impl;

import net.bus.web.controller.dto.TicketBuyItem;
import net.bus.web.model.Bus;
import net.bus.web.model.Line;
import net.bus.web.model.User;
import net.bus.web.model.UserTicket;
import net.bus.web.model.type.PointRecordType;
import net.bus.web.model.type.PointSourceType;
import net.bus.web.repository.*;
import net.bus.web.repository.specification.BusDeviceSpecification;
import net.bus.web.repository.specification.UserTicketIdSpecification;
import net.bus.web.repository.specification.UserTicketLineIdSpecification;
import net.bus.web.repository.specification.UserTicketUserIdSpecification;
import net.bus.web.service.IPointRecordService;
import net.bus.web.service.IUserTicketService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.dc.pr.PRError;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Edifi_000 on 2016-07-04.
 */
@Service
public class UserTicketService implements IUserTicketService {

    @Autowired
    private UserTicketRepository _rootRepository;
    @Autowired
    private LineRepository _lineRepository;
    @Autowired
    private UserRepository _userRepository;
    @Autowired
    private BusRepository _busRepository;
    @Autowired
    private IPointRecordService _pointRecordService;

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
        Line line = _lineRepository.getItem(line_id);
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

            user.setPoints(user.getPoints() - line.getPrice());

            _rootRepository.insertItem(userTicket);
            _userRepository.updateUser(user);

            return true;
        }
        return  false;
    }

    @Transactional
    public boolean buyTickets(String device,List<TicketBuyItem> userTickets) throws RuntimeException
    {
        if(!StringUtils.isBlank(device)){
            Bus bus = _busRepository.getItem(new BusDeviceSpecification(device));
            if(bus!=null){
                if(bus.getLineId()>0){
                    Line line = _lineRepository.getItem(bus.getLineId());
                    if(line!=null){
                        for(TicketBuyItem ticketBuyItem:userTickets){
                            //TODO 解密user_check获取user_id与check_date
                            ticketBuyItem.getUser_check();
                            Long userId = 0L;
                            Long checkDate = 0L;
                            User user = _userRepository.getUser(userId);
                            if(user!=null){
                                UserTicket userTicket = new UserTicket();
                                userTicket.setLineId(line.getId());
                                userTicket.setUserId(user.getId());
                                userTicket.setPrice(line.getPrice());
                                userTicket.setTime(new Date(checkDate));

                                user.setPoints(user.getPoints() - line.getPrice());

                                _rootRepository.insertItem(userTicket);
                                _userRepository.updateUser(user);
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

    public int getTicketsCount(long user_id)
    {
        ISpecification specification = new UserTicketUserIdSpecification(user_id);
        return _rootRepository.count(specification);
    }
}
