package com.leetcode.record.no5;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OtherSolution {
    public String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        // i,j 等同于 s.sub(i, j + 1)
        Boolean[][] dp = new Boolean[s.length()][s.length()];

        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            // i 代表每次的差
            int leftIndex = 0;
            int rightIndex = s.length();
            while ((rightIndex = leftIndex + i) < s.length()) {
                if (i == 0) {
                    dp[leftIndex][rightIndex] = true;
                } else if (i == 1) {
                    dp[leftIndex][rightIndex] = charArray[leftIndex] == charArray[rightIndex];
                } else {
                    dp[leftIndex][rightIndex] = dp[leftIndex + 1][rightIndex - 1] && charArray[leftIndex] == charArray[rightIndex];
                }

                if (dp[leftIndex][rightIndex] && right - left < rightIndex - leftIndex) {
                    right = rightIndex;
                    left = leftIndex;
                }

                leftIndex ++;
            }
        }

        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        log.info("{}", new OtherSolution().longestPalindrome("abba"));
    }
}
