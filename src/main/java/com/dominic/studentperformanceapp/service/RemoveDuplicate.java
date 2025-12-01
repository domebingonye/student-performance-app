package com.dominic.studentperformanceapp.service;

import org.springframework.stereotype.Service;

@Service
public class RemoveDuplicate {

    public int[][] removeDuplicatesFromRows(int[][] multiArray) {
        int[][] values = new int[multiArray.length][];

        for (int i = 0; i < multiArray.length; i++) {
            int[] row = multiArray[i];
            int[] newRow = new int[row.length];
            int uniqueCount = 0;
            int[] seen = new int[row.length];

            for (int j = 0; j < row.length; j++) {
                int num = row[j];
                boolean found = false;

                for (int k = 0; k < uniqueCount; k++) {
                    if (seen[k] == num) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    newRow[j] = 0;
                } else {
                    newRow[j] = num;
                    seen[uniqueCount] = num;
                    uniqueCount++;
                }
            }

            values[i] = newRow;
        }

        return values;
    }
}
