package com.leetcode.record.other;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class No2 {
    private final List<List<Integer>> result = new ArrayList<>();
    private final int[] memoryPath = new int[3];

    public List<List<Integer>> result(int[] nums1, int[] nums2, int[] nums3, int target) {
        method(nums1, nums2, nums3, target, 0);

        return result;
    }

    private void method(int[] nums1, int[] nums2, int[] nums3, int target, int pathIndex) {
        if (pathIndex == 3) {
            result.add(Arrays.stream(memoryPath).boxed().collect(Collectors.toList()));
            return;
        }

        switch (pathIndex) {
            case 0:
                for (int i = 0; i < nums1.length; i++) {
                    memoryPath[pathIndex] = i;
                    method(nums1, nums2, nums3, target - nums1[i], pathIndex + 1);
                }
                memoryPath[pathIndex] = -1;
                method(nums1, nums2, nums3, target, ++pathIndex);
                break;
            case 1:
                for (int i = 0; i < nums2.length; i++) {
                    memoryPath[pathIndex] = i;
                    method(nums1, nums2, nums3, target - nums2[i], pathIndex + 1);
                }
                memoryPath[pathIndex] = -1;
                method(nums1, nums2, nums3, target, ++pathIndex);
                break;
            case 2:
                for (int i = 0; i < nums3.length; i++) {
                    if (target == nums3[i]) {
                        memoryPath[pathIndex] = i;
                        method(nums1, nums2, nums3, target - nums3[i], pathIndex + 1);
                    }
                }

                // 这一步容易缺失
                if (target == 0) {
                    memoryPath[pathIndex] = -1;
                    method(nums1, nums2, nums3, 0, ++ pathIndex);
                }
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        log.info("{}", new No2().result(new int[]{1, 1, 1}, new int[]{0, 0, 0}, new int[]{3, 3, -1}, 0));
        log.info("{}", new No2().result(new int[]{-1, 2, 0}, new int[]{-1, 2, 1}, new int[]{-1, 2, 0}, 0));
        log.info("{}", new No2().result(new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0, 0}, 0));
        log.info("{}", new No2().result(new int[]{7, -3}, new int[]{0}, new int[]{-4, 0, 6}, 3));
        log.info("{}", new No2().result(new int[]{0, 2, 8}, new int[]{-2, 0}, new int[]{0, -3, 0}, 6));
    }
}
