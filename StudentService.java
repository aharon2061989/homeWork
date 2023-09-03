package com.studentRegistration.service;

import com.studentRegistration.model.Student;

public interface StudentService {
    void createStudent(Student student);
    void updateStudent(Student student);
    void deleteStudentById(Long id);
    Student getStudentById(Long id);
}
