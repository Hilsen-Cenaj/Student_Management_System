package com.example.student_management_system.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).get();
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    /**
     * Return all students in database
     */
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    /**
     * Save new Student
     * if email exists throw exception
     * else save student
     */
    public void saveStudent(Student student){
        boolean exists = studentRepository.findStudentByEmail(student.getEmail()).isPresent();

        if(exists) {
            throw new IllegalStateException("Email already taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Student student){
        studentRepository.delete(student);
    }
}
