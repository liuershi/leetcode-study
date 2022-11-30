package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/11/29 9:24 下午
 * @Version 1.0
 */
public class Demo1758 {

    public static int minOperations(String s) {
        int n = s.length();

        int select = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != (char) ('0' + i % 2)) {
                select++;
            }
        }

        return Math.min(select, n - select);
    }

    public static void main(String[] args) {
        System.out.println(minOperations("10010100"));
    }
}
