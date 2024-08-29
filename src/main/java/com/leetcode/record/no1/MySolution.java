package com.leetcode.record.no1;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MySolution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        // key: 下标代表的元素的值，value：下标
        Map<Integer, Integer> valueAndIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            /*
            这里可以优化一下，在这里判断是否contains就好了
             */
            valueAndIndex.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            if (valueAndIndex.containsKey(target - currentValue) && i != valueAndIndex.get(target - currentValue)) {
                result[0] = i;
                result[1] = valueAndIndex.get(target - currentValue);

                return result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        log.info("{}", mySolution.twoSum(new int[]{2, 7, 11, 15}, 9));
        log.info("{}", mySolution.twoSum(new int[]{3, 2, 4}, 6));
        log.info("{}", mySolution.twoSum(new int[]{3, 3}, 6));
    }
}
