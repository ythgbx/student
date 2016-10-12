package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.IResult;
import net.bus.web.controller.dto.MyMessageItem;
import net.bus.web.controller.dto.MyMessageList;
import net.bus.web.model.MyMessage;
import net.bus.web.model.User;
import net.bus.web.service.IMyMessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 16/10/12.
 */

@Controller
@RequestMapping("/message")
public class MyMessageController {

    @Autowired
    private IMyMessageService _messageService;
    @Autowired
    private HttpSession session;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户消息", httpMethod = "GET", response = MyMessageList.class, notes = "获取用户消息")
    public IResult all(@ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "1")int page,
                       @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "5")int limit)
    {
        logger.info("message all query");
        MyMessageList messageList = new MyMessageList();
        Long userId = null;
        User currentUser = (User) session.getAttribute(SessionContext.CURRENT_USER);
        if(currentUser!=null){
            userId = currentUser.getId();
        }
        messageList.setMessage(getDisplayList(_messageService.getUserMessages(userId, page, limit)));
        messageList.setPage(page);
        messageList.setTotal_count(_messageService.getUserMessagesCount(userId));
        return messageList;
    }


    private List<MyMessageItem> getDisplayList(List<MyMessage> newsList)
    {
        List<MyMessageItem> displayList = new ArrayList<MyMessageItem>();
        for (MyMessage message : newsList) {
            MyMessageItem disItem = new MyMessageItem();
            disItem.setId(message.getId());
            disItem.setContent(message.getContent());
            disItem.setType(message.getType());
            disItem.setTime(message.getTime().getTime());
            displayList.add(disItem);
        }
        return displayList;
    }
}
