package com.dominic.studentperformanceapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Subjects {
    MATHEMATICS("MATHEMATICS"),
    PHYSICS("PHYSICS"),
    CHEMISTRY("CHEMISTRY"),
    ENGLISH("ENGLISH"),
    BIOLOGY("BIOLOGY");

    @Getter
    private final String code;
}
