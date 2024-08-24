package com.Attendance.Payload;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

	private Integer id;
	
	private String name;
	
	List<ClassDto> allClasses;
}
