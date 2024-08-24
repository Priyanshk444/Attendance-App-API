package com.Attendance.Service;

import com.Attendance.Payload.ClassDto;

public interface ClassService {

	ClassDto addClass(ClassDto classDto,Integer courseId);
	
	ClassDto updateClass(ClassDto classDto,Integer classId);
	
}
