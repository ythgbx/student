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

import java.util.ArrayList;
import java.util.List;

@Repository
public class LineRepository {

    @Autowired
    private LineMapper _mapper;

    public List<Line> getAll() {
        LineExample example = new LineExample();
        return _mapper.selectByExample(example);
    }

    public List<Line> getAll(int page,int limit) {
        LineExample example = new LineExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<Line>();
    }

    public List<Line> getList(ISpecification specification) {
        LineExample example = (LineExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExample(example);
        }
        return new ArrayList<Line>();
    }

    public List<Line> getList(ISpecification specification,int page,int limit) {
        LineExample example = (LineExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<Line>();
    }

    public Line getItem(ISpecification specification) {
        List<Line> list= _mapper.selectByExample((LineExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public Line getItem(Long id) {
        return _mapper.selectByPrimaryKey(id);
    }

    public int insertItem(Line line)
    {
        return _mapper.insert(line);
    }

    public int updateItem(Line line)
    {
        return _mapper.updateByPrimaryKey(line);
    }

    public boolean existItem(ISpecification specification){
        int result = _mapper.countByExample((LineExample)specification.createExample());
        if(result>0)
            return true;

        return  false;
    }

    public int count(ISpecification specification)
    {
        LineExample example = (LineExample)specification.createExample();
        if(example!=null){
            return _mapper.countByExample(example);
        }
        return 0;
    }

    public int count()
    {
        return _mapper.countByExample(null);
    }
}
