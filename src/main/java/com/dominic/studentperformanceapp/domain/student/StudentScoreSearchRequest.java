package com.dominic.studentperformanceapp.domain.student;

import com.dominic.studentperformanceapp.domain.request.PagingRequest;
import lombok.Data;

@Data
public class StudentScoreSearchRequest extends PagingRequest {
    private String regNo;
}
