package com.example.student_management_system.dao;

import com.example.student_management_system.student.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getStudents();

    List<Student> getStudentById(Long id);

    List<Student> getStudentByEmail(String email);

    int insertStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudent(Student student);
}
