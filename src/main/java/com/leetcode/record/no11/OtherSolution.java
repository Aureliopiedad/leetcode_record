package com.leetcode.record.no11;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OtherSolution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) {
                ++ left;
            } else {
                -- right;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        log.info("{}", new MySolution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));

        log.info("{}", new MySolution().maxArea(new int[]{1, 1}));
    }
}
