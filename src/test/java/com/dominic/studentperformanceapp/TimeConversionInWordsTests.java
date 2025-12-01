package com.dominic.studentperformanceapp;

import com.dominic.studentperformanceapp.service.TimeConversionInWords;
import org.junit.Assert;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TimeConversionInWordsTests {
    @Autowired
    private TimeConversionInWords timeConversionInWords;

    @Test
    public void timeInWords(){
        int hour = 5, minute = 0;
        String res = timeConversionInWords.timeInWords(hour, minute);
        Assert.assertFalse(StringUtils.isBlank(res));
    }
}
