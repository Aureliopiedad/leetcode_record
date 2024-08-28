package com.leetcode.record.no1456;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySolution {
    public int maxVowels(String s, int k) {
        int result = 0;

        int left = 1;
        int right = k;

        char[] charArray = s.toCharArray();
        // 存储的是左指针下标表示的窗口中包含的元音字母的数量
        int[] isVowels = new int[charArray.length];

        // 第一个窗口需要初始化
        int firstVowel = 0;
        for (int i = 0; i < k; i ++) {
            firstVowel += findVowels(charArray[i]);
        }
        isVowels[0] = firstVowel;
        result = firstVowel;

        while (right < charArray.length) {
            int lastResult = isVowels[left - 1];
            if (findVowels(charArray[left - 1]) == 1) {
                lastResult --;
            }
            if (findVowels(charArray[right]) == 1) {
                lastResult ++;
            }
            isVowels[left] = lastResult;

            result = Math.max(result, lastResult);

            right ++;
            left ++;
        }

        return result;
    }


    private int findVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? 1 : 0;
    }

    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        log.info("{}", mySolution.maxVowels("abciiidef", 3));
        log.info("{}", mySolution.maxVowels("aeiou", 2));
        log.info("{}", mySolution.maxVowels("leetcode", 3));
        log.info("{}", mySolution.maxVowels("rhythms", 4));
        log.info("{}", mySolution.maxVowels("tryhard", 4));
        log.info("{}", mySolution.maxVowels("novowels", 1));
    }
}
