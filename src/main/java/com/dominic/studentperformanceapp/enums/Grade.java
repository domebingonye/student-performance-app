package com.dominic.studentperformanceapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Grade {
    EXCELENCE("A1", "EXCELENCE"),
    VERY_GOOD("B2", "VERY_GOOD"),
    GOOD("B3", "GOOD"),
    CREDIT("C", "CREDIT"),
    PASS("D", "PASS"),
    FAIL("F", "FAIL");

    @Getter
    private String grade;
    @Getter
    private String remark;
}
