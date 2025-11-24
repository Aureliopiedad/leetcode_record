package com.leetcode.record.no1513;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MySolution {
    private final Map<Long, Long> num = new HashMap<>();

    public int numSub(String s) {
        num.put(0L, 0L);

        long result = 0;
        String[] split = s.split("0");
        for (String string : split) {
            if (string != null && !string.isEmpty()) {
                result += help(string.length());
            }
        }

        return (int) (result % (1000000007));
    }

    private long help(long count) {
        if (num.get(count) != null) {
            return num.get(count);
        }

        long result = count * (count + 1) / 2;
        num.put(count, result);

        return result;
    }

    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        log.info("{}", mySolution.numSub("0110111"));
        log.info("{}", mySolution.numSub("101"));
        log.info("{}", mySolution.numSub("111111"));
        log.info("{}", mySolution.numSub("000"));
        log.info("{}", mySolution.numSub("1111111111011010011"));
    }
}
