package com.AksHashes.coursemanagementportal.service;

import com.AksHashes.coursemanagementportal.model.Student;
import com.AksHashes.coursemanagementportal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    //get all students
    public List<Student>getALlStudents(){
        return studentRepository.findAll();
    }

    //Get a single student by ID
    public List<Student> getStudentByCourseId(Long CourseId){
        return studentRepository.findByCourses_Id(CourseId);
    }

    //Add a new student
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    //Delete a student by ID
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}

