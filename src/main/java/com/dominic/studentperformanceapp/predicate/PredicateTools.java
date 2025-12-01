package com.dominic.studentperformanceapp.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.util.CollectionUtils;

import java.util.List;

public final class PredicateTools {

    private PredicateTools() {
    }

    public static Predicate buildPredicate(List<BooleanExpression> booleanExpressions) {
        BooleanBuilder builder = new BooleanBuilder();
        if (!CollectionUtils.isEmpty(booleanExpressions)) {
            for (BooleanExpression expr : booleanExpressions) {
                builder.and(expr);
            }
        }
        return builder;
    }
}
