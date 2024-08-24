package com.Attendance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Attendance.Models.Courses;
@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {

}
