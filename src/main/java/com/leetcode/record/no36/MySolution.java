package com.leetcode.record.no36;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySolution {
    public boolean isValidSudoku(char[][] board) {
        // board.length = 9
        // board.length[i] = 9
        // board.length[i][i] = 9

        Boolean[][] rowMembers = new Boolean[9][9];
        Boolean[][] colMembers = new Boolean[9][9];
        Boolean[][] boxMembers = new Boolean[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    continue;
                }

                int number = (int) board[row][col] - (int) '1';

                // 检查列
                if (colMembers[col][number] == null || !colMembers[col][number]) {
                    colMembers[col][number] = true;
                } else {
                    return false;
                }

                // 检查行
                if (rowMembers[row][number] == null || !rowMembers[row][number]) {
                    rowMembers[row][number] = true;
                } else {
                    return false;
                }

                // 检查九宫格
                int boxIndex = (int) row / 3 + ((int) col / 3) * 3;
                if (boxMembers[boxIndex][number] == null || !boxMembers[boxIndex][number]) {
                    boxMembers[boxIndex][number] = true;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println((int) '8' - (int) '0');
    }
}
