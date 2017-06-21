package net.bus.web.repository.specification;

import net.bus.web.model.MotivationPovo;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/6/21.
 */
public interface IMotivation {

    List<MotivationPovo> getMotivation(Map map);
    int count();
}
