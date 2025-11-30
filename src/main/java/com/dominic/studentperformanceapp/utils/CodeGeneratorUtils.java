package com.dominic.studentperformanceapp.utils;

public class CodeGeneratorUtils {

    public static String generateCode(String prefix, long count) {
        return prefix + (++count);
    }
}
