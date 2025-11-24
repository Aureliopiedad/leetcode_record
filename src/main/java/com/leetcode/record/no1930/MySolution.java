package com.leetcode.record.no1930;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class MySolution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> leftCharSet = new HashSet<>();

        int totalResult = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length - 2; i++) {
            char leftChar = charArray[i];
            if (leftCharSet.contains(leftChar)) {
                continue;
            }

            int rightIndex = findRightChar(charArray, leftChar, i);

            if (rightIndex < 0) {
                continue;
            }

            leftCharSet.add(leftChar);

            totalResult  += findDiffChar(charArray, i, rightIndex);
        }

        return totalResult;
    }

    private int findRightChar(char[] charArray, char leftChar, int leftIndex) {
        for (int i = charArray.length - 1; i >= leftIndex + 2; i--) {
            if (charArray[i] == leftChar) {
                return i;
            }
        }

        return -1;
    }

    private int findDiffChar(char[] charArray, int leftIndex, int rightIndex) {
        int result = 0;

        char[] a = Arrays.copyOfRange(charArray, leftIndex + 1, rightIndex);
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                result ++;
                continue;
            }

            if (a[i] != a[i - 1]) {
                result ++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MySolution mySolution = new MySolution();

        log.info("{}", mySolution.countPalindromicSubsequence("aabca"));
        log.info("{}", mySolution.countPalindromicSubsequence("adc"));
        log.info("{}", mySolution.countPalindromicSubsequence("bbcbaba"));
    }
}
