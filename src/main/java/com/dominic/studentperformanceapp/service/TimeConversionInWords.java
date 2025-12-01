package com.dominic.studentperformanceapp.service;

import com.dominic.studentperformanceapp.constant.NumberInWordsConstants;
import org.springframework.stereotype.Service;

@Service
public class TimeConversionInWords {

    public String timeInWords(int hour, int minute) {
        if (minute == 0) {
            return NumberInWordsConstants.numbersInWords[hour] + " o’clock";
        } else if (minute == 15) {
            return "quarter past " + NumberInWordsConstants.numbersInWords[hour];
        } else if (minute == 30) {
            return "half past " + NumberInWordsConstants.numbersInWords[hour];
        } else if (minute == 45) {
            return "quarter to " + NumberInWordsConstants.numbersInWords[(hour % 12) + 1];
        } else if (minute < 30) {
            return NumberInWordsConstants.numbersInWords[minute] + (minute == 1 ? " minute" : " minutes") + " past " + NumberInWordsConstants.numbersInWords[hour];
        } else {
            int remaining = 60 - minute;
            return NumberInWordsConstants.numbersInWords[remaining] + (remaining == 1 ? " minute" : " minutes") + " to " + NumberInWordsConstants.numbersInWords[(hour % 12) + 1];
        }
    }
}
