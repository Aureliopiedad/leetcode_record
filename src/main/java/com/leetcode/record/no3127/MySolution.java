package com.leetcode.record.no3127;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySolution {
    public boolean canMakeSquare(char[][] grid) {
        int result1 = 'B' + 'B' + 'B' + 'B';
        int result2 = 'B' + 'B' + 'B' + 'W';
        int result3 = 'W' + 'W' + 'W' + 'W';
        int result4 = 'W' + 'W' + 'W' + 'B';

        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[i].length - 1; j++) {
                int sum = grid[i][j] + grid[i + 1][j] + grid[i][j + 1] + grid[i + 1][j + 1];

                if (sum == result1 || sum == result2 || sum == result3 || sum == result4) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        log.info("{}", new MySolution().canMakeSquare(new char[][] {new char[] {'B', 'W', 'B'}, new char[] {'B', 'W', 'W'}, new char[] {'B', 'W', 'B'}}));
        log.info("{}", new MySolution().canMakeSquare(new char[][] {new char[] {'B', 'W', 'B'}, new char[] {'W', 'B', 'W'}, new char[] {'B', 'W', 'B'}}));
        log.info("{}", new MySolution().canMakeSquare(new char[][] {new char[] {'B', 'W', 'B'}, new char[] {'B', 'W', 'W'}, new char[] {'B', 'W', 'W'}}));
    }
}
