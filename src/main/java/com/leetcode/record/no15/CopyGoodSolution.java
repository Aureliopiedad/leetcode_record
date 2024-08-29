package com.leetcode.record.no15;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CopyGoodSolution {
    /*
    给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。

    注意：答案中不可以包含重复的三元组。

    输入：nums = [-4,-1,-1,0,1,,2]
     */

    private static final int TUPLE_LENGTH = 3;
    private static final int TUPLE_SUM_RESULT = 0;

    private final List<List<Integer>> results = new ArrayList<>();
    // 这个数组的长度就是答案所需的元组长度，本题就是3
    private final int[] memoryPath = new int[TUPLE_LENGTH];

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        method(false, nums, nums.length, TUPLE_LENGTH, TUPLE_SUM_RESULT, 0);

        return results;
    }

    private void method(boolean checkSame, int[] nums, int activeLength, int activeTupleLength, int target, int pathIndex) {
        if (activeLength == 0 || activeTupleLength == 0) {
            if (target == 0 && activeLength == 0) {
                results.add(Arrays.stream(memoryPath).boxed().collect(Collectors.toList()));
            }

            return;
        }

        if (activeTupleLength == 2) {
            // 为了防止重复答案，同样的元素放在前面解
            if (!checkSame && activeLength != nums.length && nums[activeLength] == nums[activeLength - 1]) {
                return;
            }

            // 双指针扫一遍
            towSum(nums, activeLength, target, pathIndex);
            return;
        }

        // 子串的每个元素加起来是否等于target
        if (activeLength == activeTupleLength) {
            // 为了防止重复答案，同样的元素放在后面解
            if (!checkSame && activeLength != nums.length && nums[activeLength] == nums[activeLength - 1]) {
                return;
            }

            for (int i = 0; i < activeLength; i++) {
                target -= nums[i];
                memoryPath[pathIndex + i] = nums[i];
            }

            if (target == 0) {
                results.add(Arrays.stream(memoryPath).boxed().collect(Collectors.toList()));
            }

            return;
        }

        // 前置判断，该子串是否能有答案
        if (activeLength < activeTupleLength
                || nums[0] + nums[1] + nums[2] > target // 最小的值如果加起来已经大于target了，也没必要看了
                || nums[activeLength - 1] + nums[activeLength - 2] + nums[activeLength - 3] < target) { // 最大的值如果加起来已经小于target了，也没必要看了
            return;
        }

        // 至此，开始准备回溯和递归
        // 相当于有一个指针从最右侧往左移动，从nums[0]到nums[activeLength - 2]的子串看看有没有结果
        method(false, nums, activeLength - 1, activeTupleLength, target, pathIndex);
        // 从nums[0]到nums[activeLength - 2]的子串结果已经出了
        // 如何判断nums[activeLength - 1]可以是构成答案的一部分：
//        if (nums[activeLength - 1] < target) {
        memoryPath[pathIndex] = nums[activeLength - 1];
        method(true, nums, activeLength - 1, activeTupleLength - 1, target - nums[activeLength - 1], pathIndex + 1);
//        }
    }

    private void towSum(int[] nums, int activeLength, int target, int pathIndex) {
        int leftIndex = 0;
        int rightIndex = activeLength - 1;

        if (leftIndex >= rightIndex
                || nums[rightIndex] + nums[rightIndex - 1] < target
                || nums[leftIndex] + nums[leftIndex + 1] > target) {
            return;
        }

        while (leftIndex < rightIndex) {
            while (rightIndex < activeLength - 1 && nums[rightIndex] == nums[rightIndex + 1]) {
                --rightIndex;
            }

            while (leftIndex > 0 && nums[leftIndex] == nums[leftIndex - 1]) {
                ++leftIndex;
            }

            if (leftIndex >= rightIndex) {
                break;
            }

            int sum = nums[leftIndex] + nums[rightIndex];
            if (sum > target) {
                --rightIndex;
            } else if (sum < target) {
                ++leftIndex;
            } else {
                memoryPath[pathIndex] = nums[leftIndex];
                memoryPath[pathIndex + 1] = nums[rightIndex];
                results.add(Arrays.stream(memoryPath).boxed().collect(Collectors.toList()));

                ++leftIndex;
                --rightIndex;
            }
        }
    }

    public static void main(String[] args) {
        log.info("{}", new CopyGoodSolution().threeSum(new int[]{0, 0, 0, 0}));
    }
}
