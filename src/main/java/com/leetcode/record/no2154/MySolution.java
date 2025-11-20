package com.leetcode.record.no2154;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class MySolution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        int index = Arrays.binarySearch(nums, original);
        while (index >= 0) {
            original = original * 2;
            index = Arrays.binarySearch(nums, index, nums.length, original);
        }

        return original;
    }

    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        log.info("{}", mySolution.findFinalValue(new int[] {5,3,6,1,12}, 3));
        log.info("{}", mySolution.findFinalValue(new int[] {2,7,9}, 4));
    }
}
