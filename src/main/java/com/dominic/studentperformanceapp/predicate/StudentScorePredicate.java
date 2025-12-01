package com.dominic.studentperformanceapp.predicate;

import com.dominic.studentperformanceapp.model.QStudentScoreEntity;
import com.querydsl.core.types.dsl.BooleanExpression;

public class StudentScorePredicate {
    public static BooleanExpression regNo(String value){
        return QStudentScoreEntity.studentScoreEntity.regNo.equalsIgnoreCase(value);
    }
}
