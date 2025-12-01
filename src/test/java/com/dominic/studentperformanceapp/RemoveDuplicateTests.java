package com.dominic.studentperformanceapp;

import com.dominic.studentperformanceapp.service.RemoveDuplicate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ObjectUtils;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RemoveDuplicateTests {
    @Autowired
    private RemoveDuplicate removeDuplicate;

    @Test
    public void removeDuplicatesFromRows(){
        int[][] multiArray = {
                {1, 2, 3, 2, 3, 4, 4, 3, 5},
                {1, 1, 1, 1, 1, 1, 1}
        };
        int[][] values = removeDuplicate.removeDuplicatesFromRows(multiArray);
        Assert.assertFalse(ObjectUtils.isEmpty(values));
    }
}
