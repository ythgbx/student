package net.bus.web.repository;

import net.bus.web.mapper.StationMapper;
import net.bus.web.model.Station;
import net.bus.web.model.StationExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-14.
 */
@Repository
public class StationRepository {

    @Autowired
    private StationMapper _mapper;

    public List<Station> getAll() {
        StationExample example = new StationExample();
        return _mapper.selectByExample(example);
    }

    public List<Station> getAll(int page,int limit) {
        StationExample example = new StationExample();
        return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page, limit)); //分页
    }

    public List<Station> getList(ISpecification specification) {
        StationExample example = (StationExample)specification.createExample();
        return _mapper.selectByExample(example);
    }

    public List<Station> getList(ISpecification specification,int page,int limit) {
        StationExample example = (StationExample)specification.createExample();
        return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page, limit)); //分页
    }

    public Station getItem(ISpecification specification) {
        List<Station> list= _mapper.selectByExample((StationExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public Station getItem(Long id) {
        return _mapper.selectByPrimaryKey(id);
    }

    public int insertItem(Station station)
    {
        return _mapper.insert(station);
    }

    public int updateItem(Station station)
    {
        return _mapper.updateByPrimaryKey(station);
    }

    public int count(ISpecification specification)
    {
        StationExample example = (StationExample)specification.createExample();
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
