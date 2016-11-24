package net.bus.web.service.impl;

import net.bus.web.common.AES;
import net.bus.web.enums.TerminalRecordState;
import net.bus.web.enums.TerminalRecordType;
import net.bus.web.model.Line;
import net.bus.web.model.LineStation;
import net.bus.web.model.TerminalRecord;
import net.bus.web.repository.TerminalRecordRepository;
import net.bus.web.repository.specification.TerminalRecordDeviceStateAndTypeSpecification;
import net.bus.web.service.ILineService;
import net.bus.web.service.ITerminalRecordService;
import net.bus.web.service.IUserTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Edifi_000 on 2016-11-21.
 */
@Service
public class TerminalRecordService implements ITerminalRecordService{

    @Autowired
    private TerminalRecordRepository _rootRepository;

    @Autowired
    private ILineService _lineService;
    @Autowired
    private IUserTicketService _userTicketService;

   public Boolean upload(String device,List<String> data){

       List<TerminalRecord> list = decryptSerialize(device,data);
       if(list!=null&&list.size()>0){
           for(int i=0;i<list.size();i++){
               _rootRepository.insertItem(list.get(i));
           }
           checkTicket(device,list.get(0).getLineId(),list.get(0).getStationId());
       }
       return true;
   }

    private List<TerminalRecord> decryptSerialize(String device,List<String> data){
        //TODO 解密设备上传的data
        List<TerminalRecord> records = new ArrayList<TerminalRecord>();
        for (String item : data) {
            String raw_data = "";
            try {
                raw_data = AES.getAesInstance().Decrypt(item);
            } catch (Exception e) {
                e.printStackTrace();
                return new ArrayList<TerminalRecord>();
            }
            String[] decode_data = raw_data.split("&");
            TerminalRecord terminalRecord = new TerminalRecord();
            /*
                S&用户名&时间&经度&维度&线路id&站点id
                C&UID&时间&精度&纬度&线路ID&站点ID
             */
            if (decode_data[0].equals("C")) {
                //TODO 数据解析
                terminalRecord.setCardUid(decode_data[1]);
                terminalRecord.setType(2);
            }
            if (decode_data[0].equals("S")) {
                //TODO 数据解析
                terminalRecord.setUserId(Long.parseLong(decode_data[1]));
                terminalRecord.setType(1);
            }
            terminalRecord.setDevice(device);
            terminalRecord.setTime(new Date((long) (Float.parseFloat(decode_data[2]) * 1000)));
            terminalRecord.setLng(Double.parseDouble(decode_data[3]));
            terminalRecord.setLat(Double.parseDouble(decode_data[4]));
            terminalRecord.setLineId(Long.parseLong(decode_data[5]));
            terminalRecord.setStationId(Long.parseLong(decode_data[6]));
            records.add(terminalRecord);
        }
        return records;
    }

    private void checkTicket(String device,Long currentLineId,Long currentStationId){
        List<TerminalRecord> list = _rootRepository.getList(new TerminalRecordDeviceStateAndTypeSpecification(device, TerminalRecordState.UNCHECKED.ordinal(), TerminalRecordType.QR.ordinal()));
        if(list!=null&&list.size()>0){
            Map<Long,ArrayList<TerminalRecord>> records = new HashMap<Long, ArrayList<TerminalRecord>>();
            for (int i = 0;i<list.size();i++){
                TerminalRecord record = list.get(i);
                if(records.containsKey(record.getUserId())){
                    records.get(record.getUserId()).add(record);
                }else{
                    ArrayList<TerminalRecord> newList = new ArrayList<TerminalRecord>();
                    newList.add(record);
                    records.put(record.getUserId(), newList);
                }
            }

            for(List<TerminalRecord> userRecords:records.values()){
                sortByTime(userRecords);
            }

            Line line=null;
            List<LineStation> lineStations=null;
            for(Long userId:records.keySet()){
                List<TerminalRecord> userRecords = records.get(userId);
                if(userRecords==null||userRecords.size()==0)
                    continue;

                //获取线路
                if(line==null||line.getId()!=userRecords.get(0).getLineId()){

                    line=_lineService.getLineDetails(currentLineId);
                    lineStations = _lineService.getLineStations(currentLineId);
                    if(line==null){
                        continue;//无法找到线路
                    }
                }

                List<List<TerminalRecord>> inPairsRecord = new ArrayList<List<TerminalRecord>>();
                int inPairsCount = 0;
                for(TerminalRecord userRecord:userRecords) {

                    //判断检票类型,是单检票还是区间检票
                    if(line.getPrice()>0){
                        //单检票
                        _userTicketService.buyTicket(line.getId(),userId);
                    }else{
                        //区间检票
                        //上车刷卡-构造序列
                        if(inPairsRecord.get(inPairsCount)==null){
                            List<TerminalRecord> ll = new ArrayList<TerminalRecord>();
                            ll.add(userRecord);
                            inPairsRecord.add(ll);
                            continue;
                        }else{
                            if(inPairsRecord.get(inPairsCount).size()==2//满足区间
                                    ||inPairsRecord.get(inPairsCount).get(0).getStationId().equals(userRecord.getStationId())//单程两次刷卡(替人刷卡的情况)
                                    ){
                                List<TerminalRecord> ll = new ArrayList<TerminalRecord>();
                                ll.add(userRecord);
                                inPairsRecord.add(ll);
                                inPairsCount++;
                                continue;
                            }
                        }

                        //下车刷卡-填空
                        for (int i=0;i<inPairsRecord.size();i++){
                            if(inPairsRecord.get(i).size()==1){
                                inPairsRecord.get(i).add(userRecord);
                            }
                        }
                    }
                }
                for (int i=0;i<inPairsRecord.size();i++){
                    if(inPairsRecord.get(i).size()==2){ //满足两次刷卡记录
                        _userTicketService.buyTicket(line.getId(),userId,inPairsRecord.get(i).get(0).getStationId(),inPairsRecord.get(i).get(1).getStationId());
                    }else{//当仅有一次刷卡记录
                        //结束点或起始
                        if(lineStations.get(0).getStationId()==currentStationId
                                ||lineStations.get(lineStations.size()-1).getStationId()==currentStationId){
                            if(inPairsRecord.get(i).get(0).getStationId()!=currentLineId){
                                //当前为结束点
                                _userTicketService.buyTicket(line.getId(),userId,inPairsRecord.get(i).get(0).getStationId(),currentStationId);
                            }
                        }
                    }
                }
                /* 上code 检票逻辑如下
                IF 单检票
                    UserTicketService.单检票(currentLineId,userId)
                ELSE-IF 区间检票(构造成对刷卡记录)
                    IF 不包含上车记录
                        区间记录新增上车记录,返回
                    ELSE
                    IF 判断是否为满足区间或为单卡多刷(帮刷的情况)
                        区间记录新增上车记录且记录索引+1,返回
                    遍历区间记录,将未标记下车的记录补充下车记录
                END
                遍历区间记录,扣费
                    IF 满足两个区间
                         UserTicketService.区间检票(currentLineId,区间上车,区间下车)
                    ELSE
                        IF 结束点（当前站点为线路两端点,且上车点不是当前站点)
                             UserTicketService.区间检票(currentLineId,区间上车,结束点)
                    END
                */
            }
        }
    }

    private void sortByTime(List<TerminalRecord> list){
        Collections.sort(list, new Comparator<TerminalRecord>() {
            //@Override
            public int compare(TerminalRecord s1, TerminalRecord s2) {
                Date dateS1 = s1.getTime();
                Date dateS2 = s2.getTime();
                return dateS1.compareTo(dateS2);
            }
        });
    }
}
