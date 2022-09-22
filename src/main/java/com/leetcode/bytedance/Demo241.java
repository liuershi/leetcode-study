package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/7/1 10:33 下午
 * @Version 1.0
 */
public class Demo241 {

    public List<Integer> diffWaysToCompute(String expression) {
        // 方法一：基于dfs实现
        sc = expression.toCharArray();
        return dfs(0, sc.length - 1);
    }

    char sc[];

    private List<Integer> dfs(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            // 如果当前字符为数字则检验下一个字符，直到当前字符为运算符时跳出
            if (Character.isDigit(sc[i])) continue;
            // 计算运算符左右两部分的结果，分治的思想
            List<Integer> ll = dfs(left, i - 1);
            List<Integer> rl = dfs(i + 1, right);
            // 双层循环判断两边能组合的所有可能
            for (Integer l : ll) {
                for (Integer r : rl) {
                    int cur;
                    // 根据当前运算符进行相应计算
                    switch (sc[i]) {
                        case '-':
                            cur = l - r;
                            break;
                        case '+':
                            cur = l + r;
                            break;
                        case '*':
                            cur = l * r;
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                    list.add(cur);
                }
            }
            
        }
        // 此时可能为当前范围内的字符串为数字，即未包含运算符
        if (list.isEmpty()) {
            int cur = 0;
            for (int j = left; j <= right; j++) cur = cur * 10 + (sc[j] - '0');
            list.add(cur);
        }
        return list;
    }

    public static void main(String[] args) {
        Demo241 demo241 = new Demo241();
        String expression = "2-1-1";
        System.out.println(demo241.diffWaysToCompute(expression));
    }
}
