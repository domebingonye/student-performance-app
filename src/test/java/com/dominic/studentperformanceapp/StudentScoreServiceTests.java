package com.dominic.studentperformanceapp;

import com.dominic.studentperformanceapp.dto.student.StudentScore;
import com.dominic.studentperformanceapp.enums.Subjects;
import com.dominic.studentperformanceapp.service.student.StudentScoreService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ObjectUtils;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentScoreServiceTests {
    @Autowired
    private StudentScoreService studentScoreService;

    @Test
    public void createStudentScore(){
        StudentScore studentScore = studentScoreService.createStudentScore(StudentScore.builder().regNo("REG4").score(60).subject(Subjects.ENGLISH).build());
        Assert.assertFalse(ObjectUtils.isEmpty(studentScore));
    }
}
