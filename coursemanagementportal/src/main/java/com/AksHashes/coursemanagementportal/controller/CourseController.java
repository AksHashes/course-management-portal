package com.AksHashes.coursemanagementportal.controller;

import com.AksHashes.coursemanagementportal.model.Courses;
import com.AksHashes.coursemanagementportal.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Courses> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    public ResponseEntity<?> addCourse(@Valid @RequestBody Courses course, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        Courses savedCourse = courseService.addCourse(course);
        return ResponseEntity.ok(savedCourse);
    }


    @GetMapping("/{id}")
    public Optional<Courses> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PutMapping("/{id}")
    public Courses updateCourse(@PathVariable Long id, @RequestBody Courses updatedCourse) {
        return courseService.updateCourse(id, updatedCourse);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "Course with ID " + id + " deleted successfully!";
    }
}
