package com.AksHashes.coursemanagementportal.controller;

import com.AksHashes.coursemanagementportal.model.Student;
import com.AksHashes.coursemanagementportal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    //Get all students
    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    //Add a student
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    //Get students by course
    @GetMapping("/courses/{courseId}")
    public List<Student> getStudentByCourses(@PathVariable("courseId") Long CourseId){
        return studentRepository.findByCourseId(courseId);
    }
}

