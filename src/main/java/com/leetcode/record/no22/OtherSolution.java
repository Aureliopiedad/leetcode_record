package com.leetcode.record.no22;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OtherSolution {
    private final List<String> result = new ArrayList<>();

    /**
     * 因为左括号一定多于或等于右括号
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return result;
        }

        StringBuilder sb = new StringBuilder();
        method(sb, n, n);

        return result;
    }

    private void method(StringBuilder stringBuilder, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(stringBuilder.toString());
            return;
        }

        // 剩余左右括号数相等，下一个只能用左括号
        if (left == right) {
            stringBuilder.append("(");
            method(stringBuilder, left - 1, right);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        if (right > left) {
            if (left > 0) {
                stringBuilder.append("(");
                method(stringBuilder, left - 1, right);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            stringBuilder.append(")");
            method(stringBuilder, left, right - 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        log.info("{}", new OtherSolution().generateParenthesis(3));
    }
}
