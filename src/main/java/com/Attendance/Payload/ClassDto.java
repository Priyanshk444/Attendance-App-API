package com.Attendance.Payload;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ClassDto {

	private Integer id;
	
	private Integer status;
	
	private LocalDateTime beginTime;
	
	private LocalDateTime endTime;
	
}
