package com.Attendance.Service;

import java.util.List;

import com.Attendance.Payload.CourseDto;

public interface CourseService {

	CourseDto addCourse(CourseDto courseDto);
	
	List<CourseDto> getAllCourse();
	
	CourseDto getCourseById(Integer courseId);
	
	void deleteCourse(Integer courseId);
	
	CourseDto updateCourseDetail(Integer courseId,CourseDto courseDto);
	
}
