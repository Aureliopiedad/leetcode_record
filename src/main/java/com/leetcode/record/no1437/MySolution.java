package com.leetcode.record.no1437;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySolution {
    public boolean kLengthApart(int[] nums, int k) {
        int currentIndex = -1;
        int lastIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                lastIndex = currentIndex;
                currentIndex = i;

                if (lastIndex < 0) {
                    lastIndex = i;
                }

                if (lastIndex == currentIndex) {
                    continue;
                }

                if (currentIndex - lastIndex <= k) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        log.info("{}", mySolution.kLengthApart(new int[]{1, 0, 0, 0, 1, 0, 0, 1}, 2));
        log.info("{}", mySolution.kLengthApart(new int[]{1, 0, 0, 1, 0, 1}, 2));
    }
}
