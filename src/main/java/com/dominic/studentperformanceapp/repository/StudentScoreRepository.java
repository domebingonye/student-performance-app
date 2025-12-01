package com.dominic.studentperformanceapp.repository;

import com.dominic.studentperformanceapp.model.StudentScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StudentScoreRepository extends JpaRepository<StudentScoreEntity, Long>, QuerydslPredicateExecutor<StudentScoreEntity> {
    boolean existsByRegNoAndSubject(String regNo, String subject);
}
