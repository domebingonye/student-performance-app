package com.dominic.studentperformanceapp;

import com.dominic.studentperformanceapp.domain.student.StudentDetails;
import com.dominic.studentperformanceapp.service.student.StudentDetailDaoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ObjectUtils;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentDetailDaoServiceTests {
    @Autowired
    private StudentDetailDaoService studentDetailDaoService;

    @Test
    public void createStudentDetails(){
        StudentDetails studentDetails = studentDetailDaoService.createStudentDetails(StudentDetails.builder().surname("OSAGIE").firstName("EMMANUELA").level("100 LEVEL").parentEmailAddress("osagie@gmail.com").build());
        Assert.assertFalse(ObjectUtils.isEmpty(studentDetails));
    }

    @Test
    public void updateStudentDetails(){
        long id = 5;
        StudentDetails studentDetails = studentDetailDaoService.updateStudentDetails(id, StudentDetails.builder().surname("Osagie").middleName("Chisom").firstName("Emmanuella").level("100 LEVEL").parentEmailAddress("osagie@gmail.com").regNo("REG5").build());
        Assert.assertFalse(ObjectUtils.isEmpty(studentDetails));
    }
}
