package com.leetcode.record.no22;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class MySolution {
    private final List<String> result = new ArrayList<>();

    /**
     * 经典回溯
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {

        StringBuilder sb = new StringBuilder();
        method(sb, 0, 0, n);

        return result;
    }

    private void method(StringBuilder stringBuilder, int left, int right, int n) {
        if (right == n) {
            result.add(stringBuilder.toString());
            return;
        }

        if (left < n) {
            stringBuilder.append("(");
            method(stringBuilder, left + 1, right, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (left > 0 && left > right) {
            stringBuilder.append(")");
            method(stringBuilder, left, right + 1, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    /*
    ((())) l+=3 r+=3
    (())() l+=2 r+=2 l+=1 r+=1
    (()()) l+=2 r+=1 l+=1 r+=2
    ()(()) l+=1 r+=1 l+=2 r+=2
    ()()() l+=1 r+=1 l+=1 r+=1 l+=1 r+=1
     */

    public static void main(String[] args) {
        log.info("{}", new MySolution().generateParenthesis(3));
    }
}
