package net.bus.web.service.impl;

import net.bus.web.mapper.TerminalRecordMapper;
import net.bus.web.model.TerminalRecord;
import net.bus.web.service.ITerminalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-11-21.
 */
@Service
public class TerminalRecordService implements ITerminalRecordService{

    @Autowired
    private TerminalRecordMapper _rootRepository;

   public Boolean upload(String device,List<String> data){

       List<TerminalRecord> list = decryptSerialize(device,data);
       for(int i=0;i<list.size();i++){
           _rootRepository.insert(list.get(i));
       }
       return true;
   }

    private List<TerminalRecord> decryptSerialize(String device,List<String> data){
        //TODO 解密设备上传的data
        return new ArrayList<TerminalRecord>();
    }
}
