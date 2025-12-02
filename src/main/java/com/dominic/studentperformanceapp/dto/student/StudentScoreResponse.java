package com.dominic.studentperformanceapp.dto.student;

import com.dominic.studentperformanceapp.enums.Subjects;
import lombok.Data;

@Data
public class StudentScoreResponse {
    private String regNo;
    private double score;
    private Subjects subject;
}
