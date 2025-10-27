package com.AksHashes.coursemanagementportal.repository;

import com.AksHashes.coursemanagementportal.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCourseId(Long courseId);
}
