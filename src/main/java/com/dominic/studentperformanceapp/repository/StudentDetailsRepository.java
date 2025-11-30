package com.dominic.studentperformanceapp.repository;

import com.dominic.studentperformanceapp.interfaces.Id;
import com.dominic.studentperformanceapp.model.StudentDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDetailsRepository extends JpaRepository<StudentDetailsEntity, Long> {
    boolean existsByRegNo(String regNo);
    Id findTopByOrderByIdDesc();
}
