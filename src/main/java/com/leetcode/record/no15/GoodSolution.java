package com.leetcode.record.no15;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class GoodSolution {
    public List<List<Integer>> threeSum(int[] nums) {
        return nSum(nums, 3, 0);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        return nSum(nums, 4, target);
    }

    /**
     * @param nums
     * @param k      几个数相加
     * @param target
     * @return
     */
    public List<List<Integer>> nSum(int[] nums, int k, int target) {
        return new AbstractList<List<Integer>>() {
            final List<List<Integer>> res = new ArrayList<>();
            final List<Integer> path = new ArrayList<>();
            long min;

            @Override
            public List<Integer> get(int index) {
                init();
                return res.get(index);
            }

            @Override
            public int size() {
                init();
                return res.size();
            }

            public void init() {
                if (res.isEmpty()) {
                    int n = nums.length;
                    long[] Arr = new long[n];
                    Arrays.sort(nums);
                    min = nums[0];
                    for (int i = 0; i < n; i++) {
                        Arr[i] = nums[i] - min;
                    }
                    long NewTarget = (long) target - (long) k * min; // NewTarget指的是：当所有的数都取最小值时，到达target的差值
                    C(false, Arr, n, k, NewTarget);
                }
            }

            //C(n, k) = C(n - 1, k) + C(n - 1, k - 1)

            /**
             *
             * @param T
             * @param a 传入的数组中，每一位和最小值的差值
             * @param n 传入的数组的长度
             * @param k 几个数相加
             * @param target
             */
            public void C(boolean T, long[] a, int n, int k, long target) {
                if (n == 0 || k == 0) {
                    if (target == 0 && k == 0) {
                        res.add(new ArrayList<>(path));
                    }
                    return;
                }
                if (k == 2) {
                    if (!T && n != a.length && a[n] == a[n - 1]) {
                        return;
                    }
                    //两数之和模板
                    twoSum(a, 0, n - 1, target);
                    return;
                }
                if (n == k) {
                    if (!T && n != a.length && a[n] == a[n - 1]) {
                        return;
                    }
                    //数组中元素和是否等于target
                    sumArr(a, n, target);
                    return;
                }
                if (check(a, n, k, target)) {
                    return;
                }
                C(false, a, n - 1, k, target);
                if (!T && n != a.length && a[n] == a[n - 1]) {
                    return;
                }
                if (target - a[n - 1] >= 0) {
                    path.add((int) (a[n - 1] + min));
                    C(true, a, n - 1, k - 1, target - a[n - 1]);
                    path.remove(path.size() - 1);
                }
            }

            void twoSum(long[] a, int l, int r, long target) {
                if (l >= r || a[r - 1] + a[r] < target || a[l] + a[l + 1] > target) {
                    return;
                }
                while (r > l) {
                    long sum = a[l] + a[r];
                    if (sum < target) {
                        l++;
                    } else if (sum > target) {
                        r--;
                    } else {
                        path.add((int) (a[l] + min));
                        path.add((int) (a[r] + min));
                        res.add(new ArrayList<>(path));
                        path.remove(path.size() - 1);
                        path.remove(path.size() - 1);
                        while (r > l && a[l] == a[l + 1]) {
                            l++;
                        }
                        while (r > l && a[r] == a[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    }
                }
            }

            void sumArr(long[] a, int n, long target) {
                for (int i = n - 1; i > -1; i--) {
                    target -= a[i];
                    path.add((int) (a[i] + min));
                }
                if (target == 0) {
                    res.add(new ArrayList<>(path));
                }
                for (int i = n - 1; i > -1; i--) {
                    target += a[i];
                    path.remove(path.size() - 1);
                }
            }

            boolean check(long[] a, int n, int k, long target) {
                if (n - k < 0) {
                    return true;
                }
                long max = 0;
                long min = 0;
                for (int i = 0; i < k; i++) { // 这个循环的意思差不多是：在差值数组a中，取最小的差值k个，取最大的差值k个
                    min += a[i];
                    max += a[n - i - 1];
                }
                if (target < min || target > max) { // 最小的差值的和如果大于期望的差值，意味着最小的几个数组元素相加一定大于希望的数值，一定没有结果；最大的差值的和如果小于期望的差值，同理
                    return true;
                }
                return false;
            }
        };
    }

    public static void main(String[] args) {
        log.info("{}", new GoodSolution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
