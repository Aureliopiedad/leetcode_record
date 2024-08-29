package com.leetcode.record.no3142;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySolution {
    public boolean satisfiesConditions(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int currentNum = grid[i][j];

                if (i != grid.length - 1 && currentNum != grid[i + 1][j]) {
                    return false;
                }

                if (j != grid[i].length - 1 && currentNum == grid[i][j + 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        log.info("{}", mySolution.satisfiesConditions(new int[][] {new int[] {1, 0, 2}, new int[] {1, 0, 2}}));
        log.info("{}", mySolution.satisfiesConditions(new int[][] {new int[] {1, 1, 1}, new int[] {0, 0, 0}}));
        log.info("{}", mySolution.satisfiesConditions(new int[][] {new int[] {1}, new int[] {2}, new int[] {3}}));
    }
}
