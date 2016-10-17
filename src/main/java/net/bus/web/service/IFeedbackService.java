package net.bus.web.service;

import net.bus.web.model.Feedback;
import net.bus.web.model.MyMessage;

import java.util.List;

/**
 * Created by sky on 16/10/13.
 */
public interface IFeedbackService {

    List<Feedback> getAllFeedback(int page, int limit);

    int getAllFeedbackCount();

    List<Feedback> getUserFeedback(Long userId, int page, int limit);

    int getUserFeedbackCount(Long userId);

    void setUserFeedback(String content, Long userId);

}
