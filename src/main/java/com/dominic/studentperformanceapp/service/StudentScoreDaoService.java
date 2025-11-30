package com.dominic.studentperformanceapp.service;

import com.dominic.studentperformanceapp.domain.student.StudentScore;
import com.dominic.studentperformanceapp.enums.Grade;
import com.dominic.studentperformanceapp.model.StudentScoreEntity;
import com.dominic.studentperformanceapp.repository.StudentScoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentScoreDaoService {
    private final StudentScoreRepository repository;
    private final ModelMapper modelMapper;

    public StudentScore save(StudentScore studentScore){
        double score = studentScore.getScore();
        if (score >= 80 && score <= 100) {
            studentScore.setRemark(Grade.EXCELENCE.getRemark());
            studentScore.setGrade(Grade.EXCELENCE.getGrade());
        } else if (score >= 70 && score < 80) {
            studentScore.setRemark(Grade.VERY_GOOD.getRemark());
            studentScore.setGrade(Grade.VERY_GOOD.getGrade());
        } else if (score >= 60 && score < 70) {
            studentScore.setRemark(Grade.GOOD.getRemark());
            studentScore.setGrade(Grade.GOOD.getGrade());
        } else if (score >= 50 && score < 60) {
            studentScore.setRemark(Grade.CREDIT.getRemark());
            studentScore.setGrade(Grade.CREDIT.getGrade());
        } else if (score >= 40 && score < 50) {
            studentScore.setRemark(Grade.PASS.getRemark());
            studentScore.setGrade(Grade.PASS.getGrade());
        } else {
            studentScore.setRemark(Grade.FAIL.getRemark());
            studentScore.setGrade(Grade.FAIL.getGrade());
        }
        StudentScoreEntity studentScoreEntity = modelMapper.map(studentScore, StudentScoreEntity.class);
        return modelMapper.map(repository.save(studentScoreEntity), StudentScore.class);
    }

    public StudentScore updateStudentScore(Long id, StudentScore studentScore){
        if(!existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No record found for studentScore");
        studentScore.setId(id);
        return save(studentScore);
    }

    private boolean existsById(Long id){
        return repository.existsById(id);
    }

    public boolean existsByRegNoAndSubject(String regNo, String subject){
        return repository.existsByRegNoAndSubject(regNo, subject);
    }
}
