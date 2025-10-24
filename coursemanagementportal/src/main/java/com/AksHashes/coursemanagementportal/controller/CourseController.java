package com.AksHashes.coursemanagementportal.controller;
import com.AksHashes.coursemanagementportal.model.Courses;
import com.AksHashes.coursemanagementportal.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;
//Get all courses
    @GetMapping
    public List<Courses> getAllCourses(){
        return courseRepository.findAll();
    }
//Add a new course
    @PostMapping
    public Courses addCourse(@RequestBody Courses courses){
        return courseRepository.save(courses);
    }
//Delete mapping("/{id}")
    @DeleteMapping("/{id}")
    public String deleteCourses(@PathVariable Long id){
        courseRepository.deleteById(id);
        return "Course deleted successfully";
    }
}
