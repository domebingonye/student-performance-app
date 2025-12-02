package com.dominic.studentperformanceapp.controller;

import com.dominic.studentperformanceapp.dto.student.StudentDetails;
import com.dominic.studentperformanceapp.dto.student.StudentScore;
import com.dominic.studentperformanceapp.dto.student.StudentScoreResponse;
import com.dominic.studentperformanceapp.dto.student.StudentScoreSearchRequest;
import com.dominic.studentperformanceapp.service.student.StudentDetailDaoService;
import com.dominic.studentperformanceapp.service.student.StudentScoreDaoService;
import com.dominic.studentperformanceapp.service.student.StudentScoreService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Operation(summary = "The score of each student in each subject")
    @GetMapping("/score/search")
    public ResponseEntity<Page<StudentScoreResponse>> searchStudentScore(StudentScoreSearchRequest request) {
        return ResponseEntity.ok().body(studentScoreDaoService.search(request));
    }

    @Operation(summary = "Mean score for each student")
    @GetMapping("/score/mean")
    public ResponseEntity<Double> meanScore(StudentScoreSearchRequest request) {
        return ResponseEntity.ok().body(studentScoreDaoService.meanScore(request));
    }

    @Operation(summary = "Mode score for each student")
    @GetMapping("/score/mode")
    public ResponseEntity<List<Double>> modelScore(StudentScoreSearchRequest request) {
        return ResponseEntity.ok().body(studentScoreDaoService.modelScore(request));
    }

    @Operation(summary = "Median score for each student")
    @GetMapping("/score/media")
    public ResponseEntity<Double> medianScore(StudentScoreSearchRequest request) {
        return ResponseEntity.ok().body(studentScoreDaoService.medianScore(request));
    }

}
