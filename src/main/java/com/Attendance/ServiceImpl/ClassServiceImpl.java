package com.Attendance.ServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Attendance.Exception.ResourceNotFoundException;
import com.Attendance.Models.Classes;
import com.Attendance.Models.Courses;
import com.Attendance.Payload.ClassDto;
import com.Attendance.Repository.ClassesRepository;
import com.Attendance.Repository.CoursesRepository;
import com.Attendance.Service.ClassService;
@Service
public class ClassServiceImpl implements ClassService {

	private CoursesRepository coursesRepository;

	private ClassesRepository classesRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public ClassServiceImpl(CoursesRepository coursesRepository, ClassesRepository classesRepository) {
		super();
		this.coursesRepository = coursesRepository;
		this.classesRepository = classesRepository;
	}
	
	
	@Override
	public ClassDto addClass(ClassDto classDto, Integer courseId) {
		Courses course = coursesRepository.findById(courseId).orElseThrow(()->new ResourceNotFoundException("Course", "all courses", courseId));
		Classes newClass = mapper.map(classDto, Classes.class);
		
		newClass.setCourse(course);
		classesRepository.save(newClass);
		
		return classDto;
	}

	@Override
	public ClassDto updateClass(ClassDto classDto, Integer classId) {
		Classes classes = classesRepository.findById(classId).orElseThrow(()->new ResourceNotFoundException("class", "class repository", classId));
		
		return null;
	}

	

}
