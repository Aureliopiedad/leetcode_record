package com.leetcode.record.no11;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySolution {
    public int maxArea(int[] height) {
        int maxArea = 0;

        for (int left = 0; left < height.length; left++) {
            maxArea = Math.max(maxArea, method(height, left));
        }

        return maxArea;
    }

    /**
     * 先把最左侧的垂线固定，从最右侧开始往左移动指针，</p>
     * min(left, right) * length 和 min(left, right1) * length1的关系，其中length > length1，</p>
     * min(left, right) 和 min(left, right1)的关系如下：</p>
     * <ol>
     *     <li>当 left <= right 时，min(left, right) = left，无论 right 和 right1关系如何，min(left, right) > min(left, right1)，所以 min(left, right) * length > min(left, right1) * length1</li>
     *     <li>当 left > right 时，min(left, right) = right，min(left, right) * length 和 min(left, right1) * length1无法确定</li>
     * </ol>
     * </p>
     * 由于矩形的宽是不断变小的且最左边的高是不变的，所以可以根据第一种情况剪枝。
     *
     * @param height
     * @param left
     * @return
     */
    private int method(int[] height, int left) {
        int maxArea = 0;

        int leftHeight = height[left];
        for (int right = height.length - 1; right > left; right--) {
            int rightHeight = height[right];
            int length = right - left;

            maxArea = Math.max(maxArea, length * Math.min(leftHeight, rightHeight));
            if (leftHeight <= rightHeight) {
                return maxArea;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        log.info("{}", new MySolution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));

        log.info("{}", new MySolution().maxArea(new int[]{1, 1}));
    }
}
