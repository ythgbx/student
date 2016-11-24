package net.bus.web.service.impl;

import net.bus.web.common.AES;
import net.bus.web.enums.TerminalRecordState;
import net.bus.web.enums.TerminalRecordType;
import net.bus.web.model.TerminalRecord;
import net.bus.web.repository.TerminalRecordRepository;
import net.bus.web.repository.specification.TerminalRecordDeviceStateAndTypeSpecification;
import net.bus.web.service.ITerminalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Edifi_000 on 2016-11-21.
 */
@Service
public class TerminalRecordService implements ITerminalRecordService {

    @Autowired
    private TerminalRecordRepository _rootRepository;

    public Boolean upload(String device, List<String> data) {

        List<TerminalRecord> list = decryptSerialize(device, data);
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                _rootRepository.insertItem(list.get(i));
            }
            checkTicket(device, list.get(0).getLineId(), list.get(0).getStationId());
        }
        return true;
    }

    private List<TerminalRecord> decryptSerialize(String device, List<String> data) {
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

    private void checkTicket(String device, Long currentLineId, Long currentStationId) {
        List<TerminalRecord> list = _rootRepository.getList(new TerminalRecordDeviceStateAndTypeSpecification(device, TerminalRecordState.UNCHECKED.ordinal(), TerminalRecordType.QR.ordinal()));
        if (list != null && list.size() > 0) {
            Map<Long, ArrayList<TerminalRecord>> records = new HashMap<Long, ArrayList<TerminalRecord>>();
            for (int i = 0; i < list.size(); i++) {
                TerminalRecord record = list.get(i);
                if (!records.containsKey(record.getUserId())) {
                    records.get(record.getUserId()).add(record);
                } else {
                    ArrayList<TerminalRecord> newList = new ArrayList<TerminalRecord>();
                    newList.add(record);
                    records.put(record.getUserId(), newList);
                }
            }

            for (List<TerminalRecord> userRecords : records.values()) {
                sortByTime(userRecords);
            }

            for (Long user_id : records.keySet()) {
                List<TerminalRecord> userRecords = records.get(user_id);
                ;
                for (TerminalRecord record : userRecords) {
                    //TODO 判断检票类型,是单检票还是区间检票
                    //IF 单检票
                    //  UserTicketService.单检票(currentLineId,currentStationId)
                    //ELSE-IF 区间检票-查找后续是否包含下车记录
                    //  IF 包含下车记录-取下车点为结束点
                    //  ELSE-IF 不包含下车记录 当前record.station!=currentStationId&&currentStationId为终点 设置终点为结束点
                    //  UserTicketService.区间检票(currentLineId,开始点,结束点)
                }

            }
        }
    }

    private void sortByTime(List<TerminalRecord> list) {
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
