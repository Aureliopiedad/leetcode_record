package com.leetcode.record.no15;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class OtherSolution {
    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        if (nums[0] + nums[1] + nums[2] > 0) {
            return res;
        }

        for (int firstIndex = 0; firstIndex < nums.length - 2; firstIndex++) {
            if (nums[firstIndex] > 0) {
                return res;
            }

            if (firstIndex > 0 && nums[firstIndex] == nums[firstIndex - 1]) {
                continue;
            }

            if (nums[firstIndex] + nums[nums.length - 1] + nums[nums.length - 2] < 0) {
                continue;
            }

            methodSecond(firstIndex, nums);
        }


        return res;
    }

    private void methodSecond(int firstIndex, int[] nums) {
        int lastIndex = nums.length - 1;

        for (int secondIndex = firstIndex + 1; secondIndex < nums.length - 1; secondIndex++) {
            if (nums[firstIndex] + nums[secondIndex] > 0) {
                return;
            }

            if (secondIndex > firstIndex + 1 && nums[secondIndex] == nums[secondIndex - 1]) {
                continue;
            }

            while (lastIndex > secondIndex && nums[firstIndex] + nums[secondIndex] + nums[lastIndex] > 0) {
                -- lastIndex;
            }

            if (lastIndex == secondIndex) {
                return;
            }

            if (nums[firstIndex] + nums[secondIndex] + nums[lastIndex] == 0) {
                res.add(Arrays.asList(nums[firstIndex], nums[secondIndex], nums[lastIndex]));
            }
        }
    }

    public static void main(String[] args) {
        log.info("{}", new OtherSolution().threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
    }
}
