package com.leetcode.record.no3025;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

@Slf4j
public class MySolution {
    public int numberOfPairs(int[][] points) {
        int count = 0;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] < o2[0] ? -1 : o1[0] == o2[0] ? Integer.compare(o2[1], o1[1]) : 1;
            }
        });


        // 优化点：因为已经排序了，所以只需要记录右下角B的纵轴即可，满足条件的点的纵坐标必须大于除A纵坐标外的最大纵坐标
        for (int i = 0; i < points.length - 1; i++) {
            int[] pointA = points[i];

            for (int j = i + 1; j < points.length; j++) {
                int[] pointB = points[j];
                if (pointA[1] < pointB[1]) {
                    continue;
                }

                if (check1(i, j, points)) {
                    count ++;
                }
            }
        }

        return count;
    }

    private boolean check1(int i, int j, int[][] points) {
        for (int k = i + 1; k < j; k ++) {
            int[] pointC = points[k];

            if (points[i][0] <= pointC[0] && points[j][0] >= pointC[0]
                    && points[i][1] >= pointC[1] && points[j][1] <= pointC[1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        log.info("{}", new MySolution().numberOfPairs(new int[][]{new int[]{3, 1}, new int[]{1, 3}, new int[]{1, 1}}));
    }
}
