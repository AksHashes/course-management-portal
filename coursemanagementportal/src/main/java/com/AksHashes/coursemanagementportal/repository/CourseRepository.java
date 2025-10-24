package com.AksHashes.coursemanagementportal.repository;

import com.AksHashes.coursemanagementportal.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CourseRepository  extends JpaRepository<Courses, Long>{
}
