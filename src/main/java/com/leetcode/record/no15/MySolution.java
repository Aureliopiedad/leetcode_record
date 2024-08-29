package com.leetcode.record.no15;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class MySolution {
    private final Map<Integer, Map<Integer, Integer>> towSumAndIndex = new HashMap<>();
    // key: 下标代表的元素的值，value：下标
    private final Map<Integer, Integer> valueAndIndex = new HashMap<>();
    private final Map<Integer, Set<Integer>> usedValues = new HashMap<>();

    public List<List<Integer>> threeSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            valueAndIndex.put(nums[i], i);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            if (!towSumAndIndex.containsKey(currentValue)) {
                twoSum(nums, currentValue, i);
                Map<Integer, Integer> integerIntegerMap = towSumAndIndex.get(currentValue);
                if (integerIntegerMap == null) {
                    continue;
                }
                integerIntegerMap.forEach((key, value) -> {
                    List<Integer> list = new ArrayList<>();
                    list.add(currentValue);
                    list.add(key);
                    list.add(value);
                    result.add(list);
                });
            }
        }

        return result;
    }

    private void twoSum(int[] nums, int target, int currentIndex) {
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            int c = (-target) - currentValue;
            if (i != currentIndex
                    && valueAndIndex.containsKey(c)
                    && currentIndex != valueAndIndex.get(c)
                    && i != valueAndIndex.get(c)
                    && (!usedValues.containsKey(- target) || !usedValues.get(- target).contains(Math.min(currentValue, c)))) {

                towSumAndIndex.computeIfAbsent(target, sum -> new HashMap<>());
                towSumAndIndex.get(target).put(Math.min(currentValue, c), Math.max(currentValue, c));

                usedValues.computeIfAbsent(target + currentValue, k -> new HashSet<>()).add(Math.min(target, currentValue));
                usedValues.computeIfAbsent(target + c, k -> new HashSet<>()).add(Math.min(target, c));
            }
        }
    }

    public static void main(String[] args) {
        log.info("{}", new MySolution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        log.info("{}", new MySolution().threeSum(new int[]{0, 1, 1}));
        log.info("{}", new MySolution().threeSum(new int[]{0, 0, 0}));
        log.info("{}", new MySolution().threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
    }
}
