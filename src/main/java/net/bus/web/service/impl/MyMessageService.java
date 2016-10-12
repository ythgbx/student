package net.bus.web.service.impl;

import net.bus.web.model.MyMessage;
import net.bus.web.repository.MyMessageRepository;
import net.bus.web.repository.specification.MyMessageUserIdOrNullSpecification;
import net.bus.web.service.IMyMessageService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sky on 16/10/12.
 */
@Service
public class MyMessageService implements IMyMessageService{
    @Autowired
    public MyMessageRepository _rootRepository;

    public  List<MyMessage> getAllMessage(int page, int limit){
        return _rootRepository.getAll(page - 1,limit);
    }

    public int getAllMessageCount(){
        return _rootRepository.count();
    }

    public List<MyMessage> getUserMessages(Long userId, int page,int limit){
        return _rootRepository.getList(new MyMessageUserIdOrNullSpecification(userId),page - 1,limit);
    }

    public int getUserMessagesCount(Long userId){
        return _rootRepository.count(new MyMessageUserIdOrNullSpecification(userId));
    }
}
