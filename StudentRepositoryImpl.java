package com.studentRegistration.repository;

import com.studentRegistration.model.Student;
import com.studentRegistration.repository.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository{

    private static final String STUDENT_TABLE_NAME = "student";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    StudentMapper studentMapper;


    @Override
    public void createStudent(Student student) {
        String sql = "INSERT INTO " + STUDENT_TABLE_NAME + " " + "(first_name, last_name, email) values (?, ?, ?)";
        jdbcTemplate.update(
                sql,
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE " + STUDENT_TABLE_NAME + " " + "SET first_name=?, last_name=?, email=? WHERE id=?";
        jdbcTemplate.update(
                sql,
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getId()
        );
    }

    @Override
    public void deleteStudentById(Long id) {
        String sql = "DELETE FROM " + STUDENT_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Student getStudentById(Long id) {
        String sql = "SELECT * FROM " + STUDENT_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, studentMapper, id);
        }
        catch (EmptyResultDataAccessException e){
            System.out.println("empty data warning");
            return null;
        }
    }


}
