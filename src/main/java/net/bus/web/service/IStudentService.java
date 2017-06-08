package net.bus.web.service;

import net.bus.web.model.Student;

/**
 * Created by sky on 16/11/29.
 */
public interface IStudentService {
    Student getStudent(String username);
}
