package net.bus.web.repository;

import net.bus.web.mapper.GrantMapper;
import net.bus.web.model.DataStatistics;
import net.bus.web.model.Grant;
import net.bus.web.model.GrantExample;
import net.bus.web.model.GrantPovo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sky on 16/12/9.
 */
@Repository
public class GrantRepository {
    @Autowired
    private GrantMapper grantMapper;

    public List<Grant> getAllGrant() {
        GrantExample example = new GrantExample();
        return grantMapper.selectByExample(example);
    }

    public List<Grant> getAllGrant(int page,int limit) {
        GrantExample example = new GrantExample();
        return grantMapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit));
    }

    public List<Grant> getAllGrantByExample(ISpecification specification,int page,int limit) {
        return grantMapper.selectByExampleWithRowbounds((GrantExample) specification.createExample(), new RowBounds(page*limit, limit));
    }

    public List<Grant> getItems(ISpecification specification) {
        GrantExample example = (GrantExample)specification.createExample();
        if(example==null)
            return new ArrayList<Grant>();

        List<Grant> list= grantMapper.selectByExample(example);
        if(!list.isEmpty())
        {
            return list;
        }

        return new ArrayList<Grant>();
    }


    public Grant getGrant(ISpecification specification)
    {
        List<Grant> list= grantMapper.selectByExample((GrantExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

//    public Grant getGrant(String id) {
//        return grantMapper.selectByPrimaryKey(id);
//    }

    public int insertGrant(Grant grant)
    {
        return grantMapper.insert(grant);
    }

    public int updateGrant(Grant grant)
    {
        return grantMapper.updateByPrimaryKey(grant);
    }

    public int Count(Map map){
        return grantMapper.countByExample(map);
    }



//    public int deleteByPrimaryKey(String id){
//        return  grantMapper.deleteByPrimaryKey(id);
//    }

    public int deleteByExample(ISpecification specification){
        return  grantMapper.deleteByExample((GrantExample) specification.createExample());
    }

//助学金查询
    public List<GrantPovo> getGrant(Map map){
        return grantMapper.selectGrant(map);
    }

    public List<DataStatistics> getNumGrant(Integer year){
        return grantMapper.getCountGrant(year);
    }


}
