package com.dominic.studentperformanceapp.dto.student;

import com.dominic.studentperformanceapp.dto.request.PagingRequest;
import lombok.Data;

@Data
public class StudentScoreSearchRequest extends PagingRequest {
    private String regNo;
}
