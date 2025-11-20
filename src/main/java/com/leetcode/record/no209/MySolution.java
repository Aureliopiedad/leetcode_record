package com.leetcode.record.no209;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySolution {
    public int minSubArrayLen(int target, int[] nums) {
        int totalCount = 0;

        int leftIndex = 0;
        int rightIndex = 0;

        int result = 0;

        while (rightIndex <= nums.length && leftIndex <= rightIndex) {
            if (totalCount < target && rightIndex < nums.length) {
                totalCount += nums[rightIndex];
                rightIndex ++;
            }

            if (totalCount >= target) {
                if (result == 0) {
                    result = rightIndex - leftIndex;
                } else {
                    result = Math.min(result, rightIndex - leftIndex);
                }

                totalCount -= nums[leftIndex];
                leftIndex ++;
            }

            if (totalCount < target && rightIndex >= nums.length) {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        log.info("{}", new MySolution().minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        log.info("{}", new MySolution().minSubArrayLen(4, new int[]{1,4,4}));
        log.info("{}", new MySolution().minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
        log.info("{}", new MySolution().minSubArrayLen(11, new int[]{1,2,3,4,5}));
        log.info("{}", new MySolution().minSubArrayLen(6, new int[]{10,2,3}));
    }
}
