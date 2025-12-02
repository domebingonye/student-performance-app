package com.dominic.studentperformanceapp;

import com.dominic.studentperformanceapp.dto.student.StudentScore;
import com.dominic.studentperformanceapp.enums.Subjects;
import com.dominic.studentperformanceapp.service.student.StudentScoreDaoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ObjectUtils;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentScoreDaoServiceTests {
    @Autowired
    private StudentScoreDaoService studentScoreDaoService;

    @Test
    public void updateStudentScore() {
        long id =3;
        StudentScore res = studentScoreDaoService.updateStudentScore(id, StudentScore.builder().regNo("REG4").score(88).subject(Subjects.CHEMISTRY).build());
        Assert.assertFalse(ObjectUtils.isEmpty(res));
    }

    @Test
    public void existsByRegNoAndSubject(){
        boolean flag = studentScoreDaoService.existsByRegNoAndSubject("REG4", Subjects.CHEMISTRY.getCode());
        Assert.assertFalse(flag);
    }
}
