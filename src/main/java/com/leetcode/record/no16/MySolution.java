package com.leetcode.record.no16;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class MySolution {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int leftIndex = 0; leftIndex < nums.length - 2; leftIndex++) {
            if (leftIndex != 0 && nums[leftIndex] == nums[leftIndex - 1]) {
                continue;
            }

            int rightIndex = leftIndex + 1;
            int lastIndex = nums.length - 1;
            while (rightIndex < lastIndex) {
                int sum = nums[leftIndex] + nums[rightIndex] + nums[lastIndex];

                // 判断三数之和偏大或偏小
                int a = sum - target;
                // 当差值变小时，更换结果
                if (Math.abs(a) < minDiff) {
                    minDiff = Math.abs(a);
                    result = sum;
                }

                if (a == 0) {
                    return result;
                }

                // 当差值大于0，认为是第三指针过右，向左移
                if (a > 0) {
                    while (rightIndex < lastIndex && nums[lastIndex] == nums[lastIndex - 1]) {
                        --lastIndex;
                    }

                    --lastIndex;
                } else {
                    // 当差值小于0，认为是第二指针过左，向右移
                    while (rightIndex < lastIndex && nums[rightIndex] == nums[rightIndex + 1]) {
                        ++rightIndex;
                    }

                    ++rightIndex;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        log.info("{}", new MySolution().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        log.info("{}", new MySolution().threeSumClosest(new int[]{0, 0, 0}, 1));
        log.info("{}", new MySolution().threeSumClosest(new int[]{-4, 2, 2, 3, 3, 3}, 0));
    }
}
