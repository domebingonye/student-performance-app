package com.dominic.studentperformanceapp.dto.request;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class PagingRequest {
    private Integer pageNumber;
    private Integer pageSize;
    private String sortBy;
    private Sort.Direction sortDirection;
}
