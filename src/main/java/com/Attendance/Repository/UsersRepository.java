package com.Attendance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Attendance.Models.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	
}
