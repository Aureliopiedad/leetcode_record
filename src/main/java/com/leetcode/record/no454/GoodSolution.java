package com.leetcode.record.no454;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GoodSolution {
    // todo
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int[] m1 = maxmin(nums1), m2 = maxmin(nums2);
        int[] m3 = maxmin(nums3), m4 = maxmin(nums4);
        int max = Math.max(m1[0] + m2[0], -m3[1] - m4[1]);
        int min = Math.min(m1[1] + m2[1], -m3[0] - m4[0]);
        int[] occur = new int[max - min + 1];
        for (int num1 : nums1)
            for (int num2 : nums2)
                occur[num1 + num2]++;
        int count = 0;
        for (int num3 : nums3)
            for (int num4 : nums4)
                count += occur[-num3 - num4];
        return count;
    }

    private int[] maxmin(int[] nums) {
        int max = -0x10000000, min = 0x10000000;
        for (int num : nums) {
            if (num > max)
                max = num;
            if (num < min)
                min = num;
        }
        return new int[] { max, min };
    }

    public static void main(String[] args) {
        log.info("{}", new GoodSolution().fourSumCount(new int[] {1, 2}, new int[] {-2, -1}, new int[] {-1, 2}, new int[] {0, 2}));
    }
}
