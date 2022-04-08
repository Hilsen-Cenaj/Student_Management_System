package com.example.student_management_system.dao;

import com.example.student_management_system.student.Student;
import com.example.student_management_system.student.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    public Optional<Student> getStudentByEmail(String email) {
        String sql = "SELECT id, username, email  FROM student WHERE email = ?";
        Student student = null;
        try {
            student = jdbcTemplate.queryForObject(sql, new Object[]{email}, new StudentRowMapper());
        } catch (DataAccessException dataAccessException){
            System.out.println("Student not found "+ email);
        }
        return Optional.ofNullable(student);
    }

    @Override
    public int insertStudent(Student student) {
        String sql = "INSERT INTO student(username, email, password) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, student.getUserName(), student.getEmail(), student.getPassword());
    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }

    @Override
    public void deleteStudent(Student student) {

    }
}
