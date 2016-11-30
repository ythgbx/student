package net.bus.web.service.impl;

import net.bus.web.model.Student;
import net.bus.web.repository.StudentRepository;
import net.bus.web.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sky on 16/11/29.
 */
@Service
class StudentService implements IStudentService{

    @Autowired
    private StudentRepository _rootRepository;
    public Student loginCheck(String sno, String password)
    {
        Student student = _rootRepository.getStudent(sno);
        if (student == null){
            return null;
        }else if (student.getPassword().equals(password)){
            return student;
        }
        return null;
    }
}
