package net.bus.web.repository;

import net.bus.web.mapper.LineStationMapper;
import net.bus.web.model.LineStation;
import net.bus.web.model.LineStationExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-14.
 */
@Repository
public class LineStationRepository {

    @Autowired
    private LineStationMapper _mapper;

    public List<LineStation> getAll() {
        LineStationExample example = new LineStationExample();
        return _mapper.selectByExample(example);
    }

    public List<LineStation> getAll(int page,int limit) {
        LineStationExample example = new LineStationExample();
        return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
    }

    public List<LineStation> getList(ISpecification specification) {
        LineStationExample example = (LineStationExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExample(example);
        }
        return new ArrayList<LineStation>();
    }

    public List<LineStation> getList(ISpecification specification,int page,int limit) {
        LineStationExample example = (LineStationExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<LineStation>();
    }

    public LineStation getItem(ISpecification specification) {
        List<LineStation> list= _mapper.selectByExample((LineStationExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public LineStation getItem(Long id) {
        return _mapper.selectByPrimaryKey(id);
    }

    public int insertItem(LineStation lineStation)
    {
        return _mapper.insert(lineStation);
    }

    public int updateItem(LineStation lineStation)
    {
        return _mapper.updateByPrimaryKey(lineStation);
    }
}
