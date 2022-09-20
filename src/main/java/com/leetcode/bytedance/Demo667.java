package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/9/8 11:35 下午
 * @Version 1.0
 */
public class Demo667 {

    public int[] constructArray(int n, int k) {
        // 思路：https://leetcode.cn/problems/beautiful-arrangement-ii/solution/you-mei-de-pai-lie-ii-by-leetcode-soluti-qkrs/
        // 时间复杂度：O(n) 空间复杂度：O(1)
        int[] res = new int[n];
        int index = 0;
        for (int i = 1; i < n - k; i++) {
            res[index++] = i;
        }

        for (int i = n - k, j = n; i <= j; i++, j--) {
            res[index++] = i;
            if (i != j) res[index++] = j;
        }
        return res;
    }
}
