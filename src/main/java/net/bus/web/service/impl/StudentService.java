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

    public Student getStudent(String username) {
        Student student = _rootRepository.getStudent(username);
        if (student!=null){
            return student;
        }
        return null;
    }

    public Boolean update(Student student) {
        if ((_rootRepository.updateStudent(student))>0){
            return true;
        }
        return false;
    }


}
