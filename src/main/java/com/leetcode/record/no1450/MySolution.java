package com.leetcode.record.no1450;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySolution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int result = 0;

        for (int i = 0; i < startTime.length; i++) {
            int start = startTime[i];
            int end = endTime[i];

            if (queryTime >= start && queryTime <= end) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
