package com.leetcode.record.no717;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySolution {
    public boolean isOneBitCharacter(int[] bits) {
        int currentIndex = 0;
        while (currentIndex < bits.length - 1) {
            if (bits[currentIndex] == 1) {
                currentIndex += 2;
                continue;
            }

            if (bits[currentIndex] == 0) {
                currentIndex++;
                continue;
            }
        }

        return currentIndex == bits.length - 1;
    }

    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        log.info("{}", mySolution.isOneBitCharacter(new int[]{1, 0, 0}));
        log.info("{}", mySolution.isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }
}
