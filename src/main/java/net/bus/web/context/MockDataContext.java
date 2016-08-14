package net.bus.web.context;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bus.web.controller.dto.*;
import net.bus.web.controller.dto.Position;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by sky on 16/7/16.
 */
public class MockDataContext {

    private static MockDataContext _instance;

    public static MockDataContext getInstance() {

        if (_instance == null) {
            synchronized (MockDataContext.class) {
                if (_instance == null) {
                    _instance = new MockDataContext();
                }
            }
        }
        return _instance;
    }

    private MockDataContext()
    {
        InitMockData();
    }

    private void InitMockData()
    {

    }

    public List<TicketItem> getTicketItemList()
    {
        List<TicketItem> displayList = new ArrayList<TicketItem>();
        for (int i=0;i<5;i++)
        {
            TicketItem disItem = new TicketItem();
            disItem.setId(-1l);
            disItem.setHead("head/1.png");
            disItem.setStart_station("民族大道中南民族大学");
            disItem.setEnd_station("中北路地铁楚河汉界站");
            disItem.setBus_img("car/1.png");
            disItem.setTime(new Date().getTime());
            displayList.add(disItem);
        }
        return displayList;
    }

    public TicketDetail getTicketDetail()
    {
        TicketDetail detail = new TicketDetail();
        detail.setStart_station("民族大道纺织大学");
        detail.setEnd_station("珞瑜路武汉大学");
        detail.setPrice(4);
        detail.setTime(new Date());
        return detail;
    }

    public List<LineItem> getLineItemList()
    {
        List<LineItem> list = new ArrayList<LineItem>();
        for (int i=0;i<5;i++)
        {
            LineItem lineItem = new LineItem();
            lineItem.setId(-1l);
            lineItem.setStart_station("中北路地铁楚河汉街站");
            lineItem.setEnd_station("民族大街纺织大学");
            lineItem.setBus_img("car/1.png");
            lineItem.setPrice(2.0);

            Calendar cal=Calendar.getInstance();
            cal.add(Calendar.HOUR_OF_DAY, 6);
            lineItem.setStart_time(cal.getTime().getTime());
            cal.set(Calendar.HOUR_OF_DAY,17);
            cal.set(Calendar.SECOND,30);
            lineItem.setEnd_time(cal.getTime().getTime());

            list.add(lineItem);
        }

        return list;
    }

    public LineDetail getLineDetail()
    {
        LineDetail lineDetail = new LineDetail();
        lineDetail.setId(-1l);
        lineDetail.setStart_station("中北路地铁楚河汉街站");
        lineDetail.setEnd_station("民族大街纺织大学");
        lineDetail.setPrice(4.0);
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, 6);
        lineDetail.setStart_time(cal.getTime().getTime());
        cal.set(Calendar.HOUR_OF_DAY,17);
        cal.set(Calendar.SECOND,30);
        lineDetail.setEnd_time(cal.getTime().getTime());
        lineDetail.setCost_time(60.0);
        lineDetail.setWait_time(2.0);
        lineDetail.setSeparated_station(2);

        double lat = 33.33;
        double lng = 44.44;
        List<LineStation> listStations = new ArrayList<LineStation>();
        for (int i=0;i<10;i++)
        {
            LineStation station = new LineStation();
            station.setIndex(i);
            station.setId(Long.parseLong(""+i));
            station.setName("name_"+i);
            station.setPos(new Position(lat+i*0.01,lng+i*0.01));
            listStations.add(station);
        }
        lineDetail.setList_stations(listStations);

        List<LineBus> listBuses = new ArrayList<LineBus>();
        for (int i=0;i<3;i++)
        {
            LineBus bus =new LineBus();
            bus.setId(-1l);
            bus.setImg("car/1.png");
            bus.setPos_in_line(i);
        }
        lineDetail.setList_buses(listBuses);

        return lineDetail;
    }
}
