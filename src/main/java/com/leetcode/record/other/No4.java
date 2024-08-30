package com.leetcode.record.other;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
public class No4 {
    public String result(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                String str1 = nums[j] + "" + nums[j + 1];
                String str2 = nums[j + 1] + "" + nums[j];

                if (str1.compareTo(str2) > 0) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        log.info("{}", new No4().result(new int[]{3, 2, 1}));
        log.info("{}", new No4().result(new int[]{10, 2}));
        log.info("{}", new No4().result(new int[]{3, 30, 34, 5, 9}));
        log.info("{}", new No4().result(new int[]{100, 71, 7, 32, 23}));
        log.info("{}", new No4().result(new int[]{3, 3, 3, 5, 9, 1}));
    }
}
