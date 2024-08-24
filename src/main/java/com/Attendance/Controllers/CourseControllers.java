package com.Attendance.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Attendance.Payload.CourseDto;
import com.Attendance.Service.ClassService;
import com.Attendance.Service.CourseService;

@RestController
@RequestMapping("/api/course")
public class CourseControllers {

	private CourseService courseService;
	
	private ClassService classService;
	
	public CourseControllers(CourseService courseService, ClassService classService) {
		super();
		this.courseService = courseService;
		this.classService = classService;
	}
	
	@PostMapping("/")
	private ResponseEntity<CourseDto> addCourse(@RequestBody CourseDto courseDto) {
		return new ResponseEntity<CourseDto>(courseService.addCourse(courseDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	private  ResponseEntity<List<CourseDto>> getAllCourse() {
		return new ResponseEntity<List<CourseDto>>(courseService.getAllCourse(),HttpStatus.OK);
	}
	
	@GetMapping("/{courseId}")
	private  ResponseEntity<CourseDto> getCourseById(@PathVariable("courseId") Integer id) {
		return new ResponseEntity<CourseDto>(courseService.getCourseById(id),HttpStatus.OK);
	}

	@DeleteMapping("/{courseId}")
	private  ResponseEntity<Void> deleteCourse(@PathVariable("courseId") Integer id) {
		courseService.deleteCourse(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
}
