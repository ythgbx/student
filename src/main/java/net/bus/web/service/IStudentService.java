package net.bus.web.service;

import net.bus.web.model.Student;
import net.bus.web.repository.ISpecification;

import java.util.List;

/**
 * Created by sky on 16/11/29.
 */
public interface IStudentService {
    Student getStudent(String username);
    List<Student> getAllStudents(int page, int limit);
    public List<Student> getAllStudentsByExample(ISpecification specification, int page, int limit);

    //得到学生的总数
    public int getCount();
    Boolean update(Student student);
}
