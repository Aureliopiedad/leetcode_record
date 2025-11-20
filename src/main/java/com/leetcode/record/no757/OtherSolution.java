package com.leetcode.record.no757;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class OtherSolution {
    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        int res = 0;
        int m = 2;

        // 先将输入的列表，按照[s, e]升序
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        List<Integer>[] temp = new List[n];
        for (int i = 0; i < n; i++) {
            temp[i] = new ArrayList<>();
        }
        // 从最后一个集合开始计算
        for (int i = n - 1; i >= 0; i--) {
            for (int j = intervals[i][0], k = temp[i].size(); k < m; j++, k++) {
                // j  指的是当前集合的s，k 指的是当前集合中有多少个数字被选取
                // 因为每个集合最少选取m个数字，所以循环条件需要加上k < m
                // 在help方法中会提前将一部分temp中添加数字，所以不用担心某个集合选取的数字超过m
                res++;
                // 从当前集合的上一个集合开始统计，是否存在该集合选取的数字同样适用的情况
                // 如果同样适用，就将被选取的数字一起加到temp中
                help(intervals, temp, i - 1, j);
            }
        }
        return res;
    }

    private void help(int[][] intervals, List<Integer>[] temp, int pos, int num) {
        for (int i = pos; i >= 0; i--) {
            if (intervals[i][1] < num) {
                break;
            }
            temp[i].add(num);
        }
    }
}
