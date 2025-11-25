package com.leetcode.record.no1262;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class MySolution {
    public int maxSumDivThree(int[] nums) {
        int result = 0;
        Arrays.sort(nums);

        List<Integer> otherList = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] % 3 == 0) {
                result += nums[i];
            } else {
                otherList.add(nums[i]);
            }
        }

        if (otherList.isEmpty()) {
            return result;
        }

        int[][] dp = new int[otherList.size()][3];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;

        for (int i = 0; i < otherList.size(); i++) {
            if (i == 0) {
                dp[0][otherList.get(i) % 3] = otherList.get(i);
                continue;
            }

            int currentNum = otherList.get(i);
            int mod = currentNum % 3;

            dp[i][0] = Math.max(dp[i - 1][0], help(dp, i, 0, mod, currentNum));
            dp[i][1] = Math.max(dp[i - 1][1], help(dp, i, 1, mod, currentNum));
            dp[i][2] = Math.max(dp[i - 1][2], help(dp, i, 2, mod, currentNum));
        }

        return result + dp[otherList.size() - 1][0];
    }

    private int help(int[][] dp, int i, int j, int mod, int currentNum) {
        if (dp[i - 1][(3 + j - mod) % 3] == 0) {
            return currentNum % 3 == 0 ? currentNum : 0;
        }

        return dp[i - 1][(3 + j - mod) % 3] + currentNum;
    }

    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        log.info("{}", mySolution.maxSumDivThree(new int[]{1, 1, 3}));
    }
}
