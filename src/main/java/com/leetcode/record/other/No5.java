package com.leetcode.record.other;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class No5 {
    /*
    数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

    示例 1：

    输入：n = 3
    输出：["((()))","(()())","(())()","()(())","()()()"]
    示例 2：

    输入：n = 1
    输出：["()"]
     */

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
        log.info("{}", new No5().generateParenthesis(1));
        log.info("{}", new No5().generateParenthesis(2));
        log.info("{}", new No5().generateParenthesis(3));
        log.info("{}", new No5().generateParenthesis(4));
    }
}
