package com.leetcode.record.no3190;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySolution {
    public int minimumOperations(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result += (num % 3 == 0 ? 0 : 1);
        }

        return result;
    }

    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        log.info("{}", mySolution.minimumOperations(new int[] {1,2,3,4}));
        log.info("{}", mySolution.minimumOperations(new int[] {3,6,9}));
    }
}
