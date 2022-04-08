package com.example.student_management_system.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping(path = "/std_mng")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Get All Students from Database (Homepage for now)
     */
    @GetMapping("/students")
    public String StudentsList(Model model){
        model.addAttribute("students", studentService.getStudents());
        return "students";
    }

    /**
     * Sign up page
     */
    @GetMapping("/signup")
    @ResponseBody
    public ModelAndView signup(){
        return new ModelAndView("../static/signup.html");
    }

    /**
     * Login page
     */
    @GetMapping("/login")
    @ResponseBody
    public ModelAndView login(){
        return new ModelAndView("../static/login.html");
    }

    /**
     * Create new Student
     */
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.addStudent(student);
        return "redirect:/students";
    }

    /**
     * Get update_student.html
     * We need id to edit Student
     */
//    @GetMapping("/students/edit/{id}")
//    public String editStudentForm(@PathVariable Long id, Model model){
//        model.addAttribute("student", studentService.getStudentById(id));
//        return "update_student";
//    }

    /**
     *
     */
//    @PostMapping("/students/{id}")
//    public String updateStudent(
//            @PathVariable Long id,
//            @ModelAttribute("student") Student student){
//
//        Student existingStudent = studentService.getStudentById(id);
//
//        existingStudent.setId(id);
//        existingStudent.setUserName(student.getUserName());
//        existingStudent.setEmail(student.getEmail());
//        existingStudent.setPassword(student.getPassword());
//
//        studentService.updateStudent(existingStudent);
//
//        return "redirect:/students";
//    }

//    @GetMapping("students/{id}")
//    public String deleteStudent(@PathVariable Long id){
//        studentService.deleteStudent(studentService.getStudentById(id));
//        return "redirect:/students";
//    }

}
