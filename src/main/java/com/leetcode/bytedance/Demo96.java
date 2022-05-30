package com.leetcode.bytedance;


/**
 * @Author milindeyu
 * @Date 2022/5/29 10:16 下午
 * @Version 1.0
 */
public class Demo96 {

    /**
     * @link https://leetcode.cn/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution/
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n < 3) return n;

        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
