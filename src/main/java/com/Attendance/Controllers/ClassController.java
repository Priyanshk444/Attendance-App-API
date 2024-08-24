package com.Attendance.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Attendance.Payload.ClassDto;
import com.Attendance.Service.ClassService;

@RestController
@RequestMapping("/api/class")
public class ClassController {

	private ClassService classService;
	
	ClassController(ClassService classService){
		this.classService = classService;
	}
	
	@PostMapping("/{courseId}")
	public ResponseEntity<ClassDto> addClass(@PathVariable("courseId") Integer id,@RequestBody ClassDto classDto) {
		return new ResponseEntity<ClassDto>(classService.addClass(classDto, id),HttpStatus.OK);
	}
}
