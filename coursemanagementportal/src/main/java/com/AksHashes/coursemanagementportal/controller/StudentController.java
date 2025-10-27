package com.AksHashes.coursemanagementportal.controller;

import com.AksHashes.coursemanagementportal.model.Student;
import com.AksHashes.coursemanagementportal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //Get all students
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getALlStudents();
    }

    //Add a student
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    //Get students by course
    @GetMapping("/courses/{courseId}")
    public List<Student> getStudentByCourses(@PathVariable("courseId") Long CourseId){
        return studentService.getStudentByCourseId(CourseId);
    }
}

