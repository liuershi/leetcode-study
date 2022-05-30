package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/5/23 10:42 下午
 * @Version 1.0
 */
public class Demo60 {

    private int[] factorial;

    private boolean[] used;

    /**
     * @see https://leetcode.cn/problems/permutation-sequence/solution/hui-su-jian-zhi-python-dai-ma-java-dai-ma-by-liwei/
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        calculateFactorial(n);
        used = new boolean[n + 1];

        StringBuilder path = new StringBuilder();
        dfs(path, n, k, 0);
        return path.toString();
    }

    private void dfs(StringBuilder path, int n, int k, int index) {
        if (path.length() == n)
            return;

        int val = factorial[n - index - 1];
        for (int i = 1; i <= n; i++) {
            if (used[i])
                continue;
            if (val < k) {
                k -= val;
                continue;
            }

            used[i] = true;
            path.append(i);
            dfs(path, n, k, ++index);
            return;
        }
    }

    /**
     * 计算阶乘
     * @param n
     * @return
     */
    public void calculateFactorial(int n) {
        factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }


    public static void main(String[] args) {
        Demo60 demo60 = new Demo60();
        System.out.println(demo60.getPermutation(9, 273815));
    }
}
