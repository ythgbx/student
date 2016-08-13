package net.bus.web.repository;

import net.bus.web.mapper.PointRecordMapper;
import net.bus.web.model.PointRecord;
import net.bus.web.model.PointRecordExample;
import net.bus.web.model.PointRecordKey;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sky on 16/7/27.
 */
@Repository
public class PointRecordRepository {
    @Autowired
    private PointRecordMapper _mapper;

    public List<PointRecord> getAll(){
        PointRecordExample example = new PointRecordExample();
        return _mapper.selectByExample(example); //分页
    }
    public List<PointRecord> getAll(int page, int limit) {
        PointRecordExample example = new PointRecordExample();
        return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
    }

    public List<PointRecord> getList(ISpecification specification){
        PointRecordExample example = (PointRecordExample) specification.createExample();
        return _mapper.selectByExample(example); //分页

    }
    public List<PointRecord> getList(ISpecification specification,int page,int limit){
        PointRecordExample example = (PointRecordExample) specification.createExample();
        return _mapper.selectByExampleWithRowbounds(example,new RowBounds(page*limit,limit)); //分页
    }

    public PointRecord getItem(PointRecordKey key){
        return _mapper.selectByPrimaryKey(key);
    }
    public int insertItem(PointRecord pointRecord)
    {
        return _mapper.insert(pointRecord);
    }

    public int updateItem(PointRecord pointRecord)
    {
        return _mapper.updateByPrimaryKey(pointRecord);
    }
    public int getCount(ISpecification specification){
        PointRecordExample example = (PointRecordExample) specification.createExample();
        return _mapper.countByExample(example);
    }
}
