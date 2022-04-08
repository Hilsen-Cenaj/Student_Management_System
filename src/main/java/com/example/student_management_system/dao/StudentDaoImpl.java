package com.example.student_management_system.dao;

import com.example.student_management_system.student.Student;
import com.example.student_management_system.student.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> getStudents() {
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    @Override
    public List<Student> getStudentById(Long id) {
        String sql = "SELECT *  FROM student WHERE student.id = id";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    public List<Student> getStudentByEmail(String email) {
        String sql = "SELECT *  FROM student WHERE student.email = email";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    @Override
    public int insertStudent(Student student) {
        String sql = "INSERT INTO student(id, username, email, password) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, student.getId(), student.getUserName(), student.getEmail(), student.getPassword());
    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }

    @Override
    public void deleteStudent(Student student) {

    }
}
