package com.dominic.studentperformanceapp.repository;

import com.dominic.studentperformanceapp.model.StudentScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentScoreRepository extends JpaRepository<StudentScoreEntity, Long> {
    boolean existsByRegNoAndSubject(String regNo, String subject);
}
