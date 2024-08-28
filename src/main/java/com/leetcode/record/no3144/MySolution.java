package com.leetcode.record.no3144;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MySolution {
    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        // d[i]指的是s.subString(0,i+1)时最少的结果
        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;

        // 因为s.subString(0,1)不算，所以从s.subString(0,2)开始
        for (int i = 1; i <= n; i++) {
            // 存储当前字串中每个字符的数量
            Map<Character, Integer> occCnt = new HashMap<>();
            // 当前子串最多的字符的个数
            int maxCnt = 0;
            // 从子串的最后一位往前推
            // 相当于取子串的子串
            for (int j = i; j >= 1; j--) {
                // 记录当前的字符出现的次数
                occCnt.put(s.charAt(j - 1), occCnt.getOrDefault(s.charAt(j - 1), 0) + 1);
                maxCnt = Math.max(maxCnt, occCnt.get(s.charAt(j - 1)));
                // 最大字数 * 字符种类 == 字串长度，意味着这个是符合条件的
                // d[j - 1] + 1 是因为既然子串的子串也是符合的，所以会+1
                if (maxCnt * occCnt.size() == (i - j + 1) && d[j - 1] != Integer.MAX_VALUE) {
                    d[i] = Math.min(d[i], d[j - 1] + 1);
                }
            }
        }
        return d[n];
    }

    public static void main(String[] args) {

    }
}
