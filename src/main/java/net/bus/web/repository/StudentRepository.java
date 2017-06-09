package net.bus.web.repository;

import net.bus.web.mapper.StudentMapper;
import net.bus.web.model.Student;
import net.bus.web.model.StudentExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 16/11/29.
 */
@Repository
public class StudentRepository {
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> getAllUsers() {
        StudentExample example = new StudentExample();
        return studentMapper.selectByExample(example);
    }

    public List<Student> getAllStudents(int page,int limit) {
        StudentExample example = new StudentExample();
        return studentMapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit));
    }

    public List<Student> getAllStudentsByExample(ISpecification specification,int page,int limit) {
        return studentMapper.selectByExampleWithRowbounds((StudentExample)specification.createExample(), new RowBounds(page*limit, limit));
    }

    public List<Student> getItems(ISpecification specification) {
        StudentExample example = (StudentExample)specification.createExample();
        if(example==null)
            return new ArrayList<Student>();

        List<Student> list= studentMapper.selectByExample(example);
        if(!list.isEmpty())
        {
            return list;
        }

        return new ArrayList<Student>();
    }


    public Student getStudent(ISpecification specification)
    {
        List<Student> list= studentMapper.selectByExample((StudentExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public Student getStudent(String username) {
        return studentMapper.selectByPrimaryKey(username);
    }

    public int insertStudent(Student student)
    {
        return studentMapper.insert(student);
    }

    public int updateStudent(Student student)
    {
        return studentMapper.updateByPrimaryKey(student);
    }

    public int Count(){
        return studentMapper.countByExample(null);
    }

    public int CountByExample(ISpecification specification){
        return studentMapper.countByExample((StudentExample)specification.createExample());
    }

    public int deleteByPrimaryKey(String sno){
        return  studentMapper.deleteByPrimaryKey(sno);
    }

    public int deleteByExample(ISpecification specification){
        return  studentMapper.deleteByExample((StudentExample) specification.createExample());
    }



}
