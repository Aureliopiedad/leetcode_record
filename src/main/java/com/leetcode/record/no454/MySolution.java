package com.leetcode.record.no454;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MySolution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();


        for (int num3 : nums3) {
            for (int num4 : nums4) {
                map.put(num3 + num4, map.getOrDefault(num3 + num4, 0) + 1);

            }
        }

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                result += map.getOrDefault(- num1 - num2, 0);
            }
        }


        return result;
    }
}
