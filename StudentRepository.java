package com.studentRegistration.repository;

import com.studentRegistration.model.Student;

public interface StudentRepository {
    void createStudent(Student student);
    void updateStudent(Student student);
    void deleteStudentById(Long id);
    Student getStudentById(Long id);
}
