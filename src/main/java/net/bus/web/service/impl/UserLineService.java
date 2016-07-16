package net.bus.web.service.impl;

import net.bus.web.model.UserLine;
import net.bus.web.repository.UserLineRepository;
import net.bus.web.service.IUserLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sky on 16/7/16.
 */
@Service
public class UserLineService implements IUserLineService {

    @Autowired
    private UserLineRepository _rootRepository;

    public int collectionLine(long userId,long lineId)
    {
        UserLine userLine = new UserLine();
        userLine.setUserId(userId);
        userLine.setLineId(lineId);

        return  _rootRepository.insertItem(userLine);
    }
}
