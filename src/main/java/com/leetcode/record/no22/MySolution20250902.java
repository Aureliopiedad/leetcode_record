package com.leetcode.record.no22;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MySolution20250902 {
    private final List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        method1(n, new StringBuilder(), 0, 0);

        return result;
    }

    private void method1(int n, StringBuilder stringBuilder, int leftCount, int rightCount) {
        if (rightCount == n) {
            result.add(stringBuilder.toString());
            return;
        }

        if (leftCount < n) {
            stringBuilder.append("(");
            method1(n, stringBuilder, leftCount + 1, rightCount);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        if (rightCount < leftCount)  {
            stringBuilder.append(")");
            method1(n, stringBuilder, leftCount, rightCount + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        log.info("{}", new MySolution20250902().generateParenthesis(3));
    }
}
