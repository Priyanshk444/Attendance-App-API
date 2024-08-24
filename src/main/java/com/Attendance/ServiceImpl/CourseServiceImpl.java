package com.Attendance.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Attendance.Exception.ResourceNotFoundException;
import com.Attendance.Models.Courses;
import com.Attendance.Payload.CourseDto;
import com.Attendance.Repository.CoursesRepository;
import com.Attendance.Service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	private CoursesRepository coursesRepository;
	
	
	@Autowired
	private ModelMapper mapper;
	
	public CourseServiceImpl(CoursesRepository coursesRepository) {
		this.coursesRepository = coursesRepository;
	}
	
	
	@Override
	public CourseDto addCourse(CourseDto courseDto) {
		Courses course = mapper.map(courseDto, Courses.class);
		Courses savedCourse = coursesRepository.save(course);
		return mapper.map(savedCourse, CourseDto.class);
	}

	@Override
	public List<CourseDto> getAllCourse() {
		List<Courses> allCourse = coursesRepository.findAll();
		List<CourseDto> allCourseDtos = allCourse.stream().map((course)->mapper.map(course, CourseDto.class)).collect(Collectors.toList());
		return allCourseDtos;
	}

	@Override
	public CourseDto getCourseById(Integer courseId) {
		Courses course = coursesRepository.findById(courseId).orElseThrow(()->new ResourceNotFoundException("Course", "all courses", courseId));
		return mapper.map(course, CourseDto.class);
	}

	@Override
	public void deleteCourse(Integer courseId) {
			coursesRepository.deleteById(courseId);
	}

	@Override
	public CourseDto updateCourseDetail(Integer courseId, CourseDto courseDto) {
		Courses course = coursesRepository.findById(courseId).orElseThrow(()->new ResourceNotFoundException("Course", "all courses", courseId));
		course.setName(courseDto.getName());
		Courses savedCourse = coursesRepository.save(course);
		return mapper.map(savedCourse, CourseDto.class);
	}

}
