package net.bus.web.repository;

/**
 * Created by Edifi_000 on 2016-07-04.
 */
import net.bus.web.mapper.LineMapper;
import net.bus.web.model.Line;
import net.bus.web.model.LineExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LineRepository {

    @Autowired
    private LineMapper _mapper;

    public List<Line> getAll() {
        LineExample example = new LineExample();
        return _mapper.selectByExampleWithRowbounds(example, new RowBounds(1, 2)); //分页
    }

    public Line getItem(Long id) {
        return _mapper.selectByPrimaryKey(id);
    }
}
