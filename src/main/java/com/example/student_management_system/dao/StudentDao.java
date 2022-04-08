package com.example.student_management_system.dao;

import com.example.student_management_system.student.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

    List<Student> getStudents();

    List<Student> getStudentById(Long id);

    Optional<Student> getStudentByEmail(String email);

    int insertStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudent(Student student);
}
