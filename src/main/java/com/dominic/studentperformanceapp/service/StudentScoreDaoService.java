package com.dominic.studentperformanceapp.service;

import com.dominic.studentperformanceapp.domain.student.StudentScore;
import com.dominic.studentperformanceapp.domain.student.StudentScoreResponse;
import com.dominic.studentperformanceapp.domain.student.StudentScoreSearchRequest;
import com.dominic.studentperformanceapp.enums.Grade;
import com.dominic.studentperformanceapp.model.StudentScoreEntity;
import com.dominic.studentperformanceapp.predicate.PredicateTools;
import com.dominic.studentperformanceapp.predicate.StudentScorePredicate;
import com.dominic.studentperformanceapp.repository.StudentScoreRepository;
import com.dominic.studentperformanceapp.utils.RestControllerUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    private Predicate buildPredicate(StudentScoreSearchRequest request){
        List<BooleanExpression> booleanExpressionList = new ArrayList<>();

        if(StringUtils.hasText(request.getRegNo())){
            booleanExpressionList.add(StudentScorePredicate.regNo(request.getRegNo()));
        }
        return PredicateTools.buildPredicate(booleanExpressionList);
    }

    public Page<StudentScoreResponse> search(StudentScoreSearchRequest request){
        Predicate predicate = buildPredicate(request);
        Sort.Direction sortDirection = Sort.Direction.DESC;
        Integer pageNumber = request.getPageNumber();
        if(pageNumber == null || pageNumber <2){
            request.setPageNumber(0);
        }
        else{
            request.setPageNumber(pageNumber-1);
        }
        PageRequest pageRequest = RestControllerUtils.createPageRequest(StudentScoreResponse.class, request.getPageNumber(), request.getPageSize(), request.getSortBy(), sortDirection);
        log.info("StudentScore PAGE REQUEST ::: ::: " + pageRequest);
        return findAll(predicate, pageRequest);
    }

    public Page<StudentScoreResponse> findAll(Predicate predicate, PageRequest pageRequest) {
        return repository.findAll(predicate, pageRequest).map(entity -> modelMapper.map(entity, StudentScoreResponse.class));
    }

    public List<StudentScoreResponse> getAllStudentScore(StudentScoreSearchRequest request){
        Page<StudentScoreResponse> studentScoreResponsePage = search(request);
        if(studentScoreResponsePage == null || studentScoreResponsePage.isEmpty()){
            return Collections.emptyList();
        }

        return studentScoreResponsePage.getContent();
    }

    public Double meanScore(StudentScoreSearchRequest request){
        List<StudentScoreResponse> studentScoreResponseList = getAllStudentScore(request);
        return studentScoreResponseList.stream().mapToDouble(StudentScoreResponse::getScore).average().orElse(0.0);
    }
}
