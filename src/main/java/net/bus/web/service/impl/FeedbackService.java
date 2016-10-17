package net.bus.web.service.impl;

import net.bus.web.model.Feedback;
import net.bus.web.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.bus.web.service.IFeedbackService;

import java.util.Date;
import java.util.List;

/**
 * Created by sky on 16/10/13.
 */
@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    private FeedbackRepository _feedbackRepository;

    public List<Feedback> getAllFeedback(int page, int limit) {
        return _feedbackRepository.getAll(page - 1,limit);
    }

    public int getAllFeedbackCount() {
        return _feedbackRepository.count();
    }

    public List<Feedback> getUserFeedback(Long userId, int page, int limit) {
        return null;
    }

    public int getUserFeedbackCount(Long userId) {
        return 0;
    }

    public void setUserFeedback(String content, Long userId) {
        Feedback feedback = new Feedback();
        feedback.setContent(content);
        feedback.setUserId(userId);
        feedback.setTime(new Date());
        _feedbackRepository.insertItem(feedback);
    }
}
