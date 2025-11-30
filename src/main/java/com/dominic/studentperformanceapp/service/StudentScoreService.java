package com.dominic.studentperformanceapp.service;

import com.dominic.studentperformanceapp.domain.student.StudentScore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentScoreService {
    private final StudentScoreDaoService studentScoreDaoService;
    private final StudentDetailDaoService studentDetailDaoService;

    public StudentScore createStudentScore(StudentScore studentScore){
        validateStudentRegNo(studentScore.getRegNo(), studentScore.getSubject().getCode());
        return studentScoreDaoService.save(studentScore);
    }

    private void validateStudentRegNo(String regNo, String subject){
        if(!studentDetailDaoService.existsByRegNo(regNo)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, regNo + " as a reg number does not exist");
        if(studentScoreDaoService.existsByRegNoAndSubject(regNo, subject)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Record already exist");
    }
}
