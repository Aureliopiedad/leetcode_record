package com.leetcode.record.no5;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySolution {
    public String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();

        int leftIndex = 0;
        int rightIndex = 0;

        // i 指的是最右侧的指针
        for (int i = 0; i < charArray.length; i++) {
            int result = -1;
            if ((result = func1(charArray, i)) != -1 && (rightIndex - leftIndex) < (i - result)) {
                rightIndex = i;
                leftIndex = result;
            }
        }

        return s.substring(leftIndex, rightIndex + 1);
    }

    private int func1(char[] charArray, int rightIndex) {
        for (int i = 0; i < rightIndex; i++) {
            if (check1(charArray, i, rightIndex)) {
                return i;
            }
        }

        return -1;
    }

    private boolean check1(char[] charArray, int leftIndex, int rightIndex) {
        int i = leftIndex;
        int j = rightIndex;

        while (i < j) {
            if (charArray[i] == charArray[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        log.info("{}", new MySolution().longestPalindrome("cbbd"));
    }
}
