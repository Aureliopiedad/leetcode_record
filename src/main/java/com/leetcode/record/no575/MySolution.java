package com.leetcode.record.no575;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class MySolution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> typeSet = new HashSet<>();
        int maxCount = candyType.length / 2;
        int result = 0;

        for (int type : candyType) {
            if (typeSet.add(type)) {
                ++result;
            }

            if (result == maxCount) {
                return result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MySolution mySolution = new MySolution();

        log.info("{}", mySolution.distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
        log.info("{}", mySolution.distributeCandies(new int[]{1, 1, 2, 3}));
        log.info("{}", mySolution.distributeCandies(new int[]{6, 6, 6, 6}));
    }
}
