package com.dominic.studentperformanceapp.controller;

import com.dominic.studentperformanceapp.domain.student.StudentDetails;
import com.dominic.studentperformanceapp.domain.student.StudentScore;
import com.dominic.studentperformanceapp.service.StudentDetailDaoService;
import com.dominic.studentperformanceapp.service.StudentScoreDaoService;
import com.dominic.studentperformanceapp.service.StudentScoreService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/student")
public class StudentController {
    private final StudentDetailDaoService studentDetailDaoService;
    private final StudentScoreService studentScoreService;
    private final StudentScoreDaoService studentScoreDaoService;

    @Operation(summary = "creating a student")
    @PostMapping("/details")
    public ResponseEntity<StudentDetails> createStudentDetails(@Validated @RequestBody StudentDetails studentDetails) {
        return ResponseEntity.ok().body(studentDetailDaoService.createStudentDetails(studentDetails));
    }

    @Operation(summary = "update a student")
    @PutMapping("/details/{id}")
    public ResponseEntity<StudentDetails> updateStudentDetails(@PathVariable final Long id, @Validated @RequestBody StudentDetails studentDetails) {
        return ResponseEntity.ok().body(studentDetailDaoService.updateStudentDetails(id, studentDetails));
    }

    @Operation(summary = "creating a student score")
    @PostMapping("/score")
    public ResponseEntity<StudentScore> createStudentScore(@Validated @RequestBody StudentScore studentScore) {
        return ResponseEntity.ok().body(studentScoreService.createStudentScore(studentScore));
    }

    @Operation(summary = "update student score")
    @PutMapping("/score/{id}")
    public ResponseEntity<StudentScore> updateStudentScore(@PathVariable final Long id, @Validated @RequestBody StudentScore studentScore) {
        return ResponseEntity.ok().body(studentScoreDaoService.updateStudentScore(id, studentScore));
    }
}
