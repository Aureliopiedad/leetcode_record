package com.leetcode.record.other;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No3 {
    /**
     * 网上抄的最多约数
     *
     * @param n
     * @return
     */
    public int result(int n) {
        int a = 0, b = n;
        int m = 0;
        int temp = 0;
        int x = 0;

        for (int i = a; i <= b; i++) {
            temp = div(i);
            if (temp > m) {
                m = temp;
                x = i;
            }
        }

        return m;
    }

    private int div(int num) {
        int count = 0;
        int[] result = new int[num + 1];
        int temp = num;
        int total = 1;

        for (int i = 2; i <= num / 2; i++) {
            if (sushu(i))//是素数
            {
                if (temp % i == 0)//是质因数
                {
                    count = 0;
                    while (temp % i == 0) {
                        count++;//质因数个数
                        temp = temp / i;
                    }
                    result[i] = count;//存入数组
                }
            }
        }
        for (int i = 2; i <= num; i++) {
            if (result[i] != 0)
                total = total * (result[i] + 1);//公式求约数个数
        }
        return total;
    }

    private boolean sushu(int num)//判断这个数是不是质数
    {
        int flag = 1;
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                flag = 0;
                break;
            }
        }
        return flag == 1;
    }

    public static void main(String[] args) {
        log.info("{}", new No3().result(4));
        log.info("{}", new No3().result(64));
        log.info("{}", new No3().result(100));
        log.info("{}", new No3().result(20));
        log.info("{}", new No3().result(256));
        log.info("{}", new No3().result(1));
    }
}
