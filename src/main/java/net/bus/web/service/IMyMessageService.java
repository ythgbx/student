package net.bus.web.service;

import net.bus.web.model.MyMessage;

import java.util.List;

/**
 * Created by sky on 16/10/12.
 */
public interface IMyMessageService {

    List<MyMessage> getAllMessage(int page,int limit);

    int getAllMessageCount();

    List<MyMessage> getUserMessages(Long userId, int page,int limit);

    int getUserMessagesCount(Long userId);

}
