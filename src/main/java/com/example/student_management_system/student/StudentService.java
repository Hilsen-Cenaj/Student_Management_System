package com.example.student_management_system.student;

import com.example.student_management_system.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

//
//    public Student updateStudent(Student student){
//        return studentRepository.save(student);
//    }

    /**
     * Return all students in database
     */
    public List<Student> getStudents(){
        return studentDao.getStudents();
    }

    /**
     * Save new Student
     * if email exists throw exception
     * else save student
     */
    public void addStudent(Student student) {
        int result = studentDao.insertStudent(student);
        if (result != 1) {
            throw new IllegalStateException("something went wrong");
        }
    }

    public Optional<Student> getStudentByEmail(String email){
        return studentDao.getStudentByEmail(email);
    }

//
//    public void deleteStudent(Student student){
//        studentRepository.delete(student);
//    }
}
