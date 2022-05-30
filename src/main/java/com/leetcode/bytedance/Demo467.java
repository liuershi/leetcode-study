package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/25 11:46 下午
 * @Version 1.0
 */
public class Demo467 {

    public int findSubstringInWraproundString(String p) {
        int len = 0;
        if (p == null || (len = p.length()) <= 1)
            return len;

        int sum = len;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int left = p.charAt(i) - '0';
                int right = p.charAt(j) - '0';
                int diff;
                if (left > right) {
                    diff = right - (left - 26);
                } else {
                    diff = right - left;
                }

                if (j - i != diff && j - i > 1) {
                    sum += factorial(j - i);
                    i = j;
                }
            }
        }
        return sum;
    }

    public int factorial(int n) {
        int rsp = 1;
        for (int i = 2; i <= n; i++) {
            rsp *= i;
        }
        return rsp;
    }

    public static void main(String[] args) {
        Demo467 demo467 = new Demo467();
        System.out.println(demo467.findSubstringInWraproundString("cac"));
    }
}
