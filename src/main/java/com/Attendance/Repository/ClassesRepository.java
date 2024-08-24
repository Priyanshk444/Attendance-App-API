package com.Attendance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Attendance.Models.Classes;
@Repository
public interface ClassesRepository extends JpaRepository<Classes, Integer> {

}
