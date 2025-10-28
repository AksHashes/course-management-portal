package com.AksHashes.coursemanagementportal.service;

import com.AksHashes.coursemanagementportal.model.Courses;
import com.AksHashes.coursemanagementportal.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Get all courses
    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    // Add new course
    public Courses addCourse(Courses course) {
        return courseRepository.save(course);
    }

    // Get single course by ID
    public Optional<Courses> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    // Update existing course
    public Courses updateCourse(Long id, Courses updatedCourse) {
        Courses course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + id));

        course.setName(updatedCourse.getName());
        course.setDescription(updatedCourse.getDescription());
        return courseRepository.save(course);
    }

    // Delete course by ID
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
