package com.leetcode.record.other;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class No1 {
    private final List<List<Integer>> result = new ArrayList<>();
    private final int[] memoryPath = new int[3];

//    注释行是为了验证答案是否正确，与题无关无关
//    private final Map<Integer, Integer> map = new HashMap<>();
//
//    private int checkCount(int[] nums1, int[] nums2, int[] nums3, int target) {
//        for (int num1 : nums1) {
//            for (int num2 : nums2) {
//                map.put(num1 + num2, map.getOrDefault(num1 + num2, 0) + 1);
//            }
//        }
//
//        int res = 0;
//        for (int num3 : nums3) {
//            res += map.getOrDefault(target - num3, 0);
//        }
//        return res;
//    }

    public List<List<Integer>> result(int[] nums1, int[] nums2, int[] nums3, int target) {
//        log.info(String.valueOf(checkCount(nums1, nums2, nums3, target)));

        for (int i = 0; i < nums1.length; i++) {
            memoryPath[0] = i;
            method(nums1, nums2, nums3, target - nums1[i], 1);
        }

        return result;
    }

    private void method(int[] nums1, int[] nums2, int[] nums3, int target, int pathIndex) {
        if (pathIndex == 3) {
            result.add(Arrays.stream(memoryPath).boxed().collect(Collectors.toList()));
            return;
        }

        switch (pathIndex) {
            case 1:
                for (int i = 0; i < nums2.length; i++) {
                    memoryPath[pathIndex] = i;
                    method(nums1, nums2, nums3, target - nums2[i], pathIndex + 1);
                }
                break;
            case 2:
                for (int i = 0; i < nums3.length; i++) {
                    if (target == nums3[i]) {
                        memoryPath[pathIndex] = i;
                        method(nums1, nums2, nums3, target - nums3[i], pathIndex + 1);
                    }
                }
                break;
            default:
                return;
        }
    }

    public static void main(String[] args) {
        log.info("{}", new No1().result(new int[]{-1, 2, 0}, new int[]{-1, 2, 1}, new int[]{-1, 2, 0}, 0));
        log.info("{}", new No1().result(new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0, 0}, 0));
        log.info("{}", new No1().result(new int[]{7, -3}, new int[]{0}, new int[]{-4, 0, 6}, 3));
        log.info("{}", new No1().result(new int[]{0, 2, 8}, new int[]{-2, 0}, new int[]{0, -3, 0}, 6));
    }
}
