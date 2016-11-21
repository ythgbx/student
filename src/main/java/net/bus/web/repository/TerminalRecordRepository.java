package net.bus.web.repository;

import net.bus.web.mapper.TerminalRecordMapper;
import net.bus.web.model.TerminalRecord;
import net.bus.web.model.TerminalRecordExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-11-21.
 */
@Repository
public class TerminalRecordRepository {
    @Autowired
    private TerminalRecordMapper _mapper;

    public List<TerminalRecord> getAll() {
        TerminalRecordExample example = new TerminalRecordExample();
        return _mapper.selectByExample(example);
    }

    public List<TerminalRecord> getAll(int page,int limit) {
        TerminalRecordExample example = new TerminalRecordExample();
        return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page * limit, limit)); //分页
    }

    public List<TerminalRecord> getList(ISpecification specification) {
        TerminalRecordExample example = (TerminalRecordExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExample(example);
        }
        return new ArrayList<TerminalRecord>();
    }

    public List<TerminalRecord> getList(ISpecification specification,int page,int limit) {
        TerminalRecordExample example = (TerminalRecordExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page * limit, limit)); //分页
        }
        return new ArrayList<TerminalRecord>();
    }

    public TerminalRecord getItem(ISpecification specification) {
        List<TerminalRecord> list= _mapper.selectByExample((TerminalRecordExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public TerminalRecord getItem(Long id) {
        return _mapper.selectByPrimaryKey(id);
    }

    public int insertItem(TerminalRecord station)
    {
        return _mapper.insert(station);
    }

    public int updateItem(TerminalRecord station)
    {
        return _mapper.updateByPrimaryKey(station);
    }

    public int count(ISpecification specification)
    {
        TerminalRecordExample example = (TerminalRecordExample)specification.createExample();
        if(example!=null){
            return _mapper.countByExample(example);
        }
        return 0;
    }

    public int count()
    {
        return _mapper.countByExample(null);
    }

    public int delete(ISpecification Specification) {
        return _mapper.deleteByExample((TerminalRecordExample) Specification.createExample());
    }
    public int delete(Long id) {
        return _mapper.deleteByPrimaryKey(id);
    }
}
