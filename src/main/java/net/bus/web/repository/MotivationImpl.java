package net.bus.web.repository;

import net.bus.web.model.MotivationPovo;
import net.bus.web.repository.specification.IMotivation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/6/21.
 */
@Repository
public class MotivationImpl implements IMotivation {


    @Autowired
    private MotivationalMapper motivationalMapper;

    public List<MotivationPovo> getMotivation(Map map) {
        return motivationalMapper.selectMotivation(map);
    }

    public int count() {
        return motivationalMapper.countByExample(null);
    }


}
