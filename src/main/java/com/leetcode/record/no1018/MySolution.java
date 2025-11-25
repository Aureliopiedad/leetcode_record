package com.leetcode.record.no1018;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MySolution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int prefix = 0;
        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefix = nums[i] % 5;
                result.add(prefix == 0);
                continue;
            }

            prefix = ((prefix << 1) + nums[i]) % 5;
            result.add(prefix == 0);
        }

        return result;
    }

    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        log.info("{}", mySolution.prefixesDivBy5(new int[]{0, 1, 1}));
        log.info("{}", mySolution.prefixesDivBy5(new int[]{1, 1, 1}));
    }
}
