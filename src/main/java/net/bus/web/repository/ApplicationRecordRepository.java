package net.bus.web.repository;

import net.bus.web.mapper.ApplicationRecordMapper;
import net.bus.web.model.ApplicationRecord;
import net.bus.web.model.ApplicationRecordExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yth on 2017/6/16.
 */
@Repository
public class ApplicationRecordRepository {
    @Autowired
    private ApplicationRecordMapper applicationRecordMapper;


    public List<ApplicationRecord> getAllGrant() {
        ApplicationRecordExample example = new ApplicationRecordExample();
        return applicationRecordMapper.selectByExample(example);
    }

    public List<ApplicationRecord> getAllGrant(int page,int limit) {
        ApplicationRecordExample example = new ApplicationRecordExample();
        return applicationRecordMapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit));
    }

    public List<ApplicationRecord> getAllGrantByExample(ISpecification specification,int page,int limit) {
        return applicationRecordMapper.selectByExampleWithRowbounds((ApplicationRecordExample) specification.createExample(), new RowBounds(page*limit, limit));
    }

    public List<ApplicationRecord> getItems(ISpecification specification) {
        ApplicationRecordExample example = (ApplicationRecordExample)specification.createExample();
        if(example==null)
            return new ArrayList<ApplicationRecord>();

        List<ApplicationRecord> list= applicationRecordMapper.selectByExample(example);
        if(!list.isEmpty())
        {
            return list;
        }

        return new ArrayList<ApplicationRecord>();
    }


    public ApplicationRecord getApplicationRecord(ISpecification specification)
    {
        List<ApplicationRecord> list= applicationRecordMapper.selectByExample((ApplicationRecordExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

//    public Grant getGrant(String id) {
//        return grantMapper.selectByPrimaryKey(id);
//    }

    public int insert(ApplicationRecord applicationRecord)
    {
        return applicationRecordMapper.insert(applicationRecord);
    }

    public int updateGrant(ApplicationRecord applicationRecord)
    {
        return applicationRecordMapper.updateByPrimaryKey(applicationRecord);
    }

    public int Count(){
        return applicationRecordMapper.countByExample(null);
    }

    public int CountByExample(ISpecification specification){
        return applicationRecordMapper.countByExample((ApplicationRecordExample)specification.createExample());
    }

//    public int deleteByPrimaryKey(String id){
//        return  grantMapper.deleteByPrimaryKey(id);
//    }

    public int deleteByExample(ISpecification specification){
        return  applicationRecordMapper.deleteByExample((ApplicationRecordExample) specification.createExample());
    }
}
