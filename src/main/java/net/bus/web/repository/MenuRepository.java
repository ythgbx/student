package net.bus.web.repository;

import net.bus.web.mapper.ClassnameMapper;
import net.bus.web.mapper.CollegeMapper;
import net.bus.web.mapper.ProfessionalMapper;
import net.bus.web.model.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yth on 2017/6/11.
 */
@Repository
public class MenuRepository {
    @Autowired
    private CollegeMapper collegeMapper;
    @Autowired
    private ProfessionalMapper professionalMapper;
    @Autowired
    private ClassnameMapper classnameMapper;

    public List<College> getAllColleges() {
        CollegeExample example = new CollegeExample();
        return collegeMapper.selectByExample(example);
    }

    public List<Professional> getAllProfessional() {
        ProfessionalExample example = new ProfessionalExample();
        return professionalMapper.selectByExample(example);
    }

    public List<Professional> getAllProfessional(ISpecification specification) {

        return professionalMapper.selectByExample((ProfessionalExample) specification.createExample());
    }

    public List<Classname> getAllClassName(){
        ClassnameExample example = new ClassnameExample();
        return classnameMapper.selectByExample(example);
    }

    public List<Classname> getAllClassName(ISpecification specification) {

        return classnameMapper.selectByExample((ClassnameExample) specification.createExample());
    }


    public int insertCollege(College college)
    {
        return collegeMapper.insert(college);
    }

    public int insertProfessional(Professional professional)
    {
        return professionalMapper.insert(professional);
    }

    public int insertClassname(Classname classname)
    {
        return classnameMapper.insert(classname);
    }


//
//    public List<User> getAllUsers(int page,int limit) {
//        UserExample example = new UserExample();
//        return userMapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit));
//    }
//
//    public List<User> getAllUsersByExample(ISpecification specification,int page,int limit) {
//        return userMapper.selectByExampleWithRowbounds((UserExample) specification.createExample(), new RowBounds(page*limit, limit));
//    }
//
//    public List<User> getItems(ISpecification specification) {
//        UserExample example = (UserExample)specification.createExample();
//        if(example==null)
//            return new ArrayList<User>();
//
//        List<User> list= userMapper.selectByExample(example);
//        if(!list.isEmpty())
//        {
//            return list;
//        }
//
//        return new ArrayList<User>();
//    }
//
//
//    public User getUser(ISpecification specification)
//    {
//        List<User> list= userMapper.selectByExample((UserExample)specification.createExample());
//        if(!list.isEmpty())
//        {
//            return list.get(0);
//        }
//
//        return null;
//    }
//
//    public User getUser(String id) {
//        return userMapper.selectByPrimaryKey(id);
//    }
//
//    public int insertUser(User user)
//    {
//        return userMapper.insert(user);
//    }
//
//    public int updateUser(User user)
//    {
//        return userMapper.updateByPrimaryKey(user);
//    }
//
//    public int Count(){
//        return userMapper.countByExample(null);
//    }
//
//    public int CountByExample(ISpecification specification){
//        return userMapper.countByExample((UserExample)specification.createExample());
//    }
//
//    public int deleteByPrimaryKey(String id){
//        return  userMapper.deleteByPrimaryKey(id);
//    }
//
//    public int deleteByExample(ISpecification specification){
//        return  userMapper.deleteByExample((UserExample) specification.createExample());
//    }

}
