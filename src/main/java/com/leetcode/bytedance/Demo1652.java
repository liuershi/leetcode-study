package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @author zhangwei151
 * @date 2022/9/24 10:40
 */
public class Demo1652 {

    public int[] decrypt(int[] code, int k) {
        // 思路一：基于滑动窗口和双指针
        // 重点：将数组code扩展为 code + code ，方便边界处理
        // 时间和空间复杂度: O(n)
        int len = code.length;
        int[] res = new int[len];
        if (k == 0) return res;
        int[] copy = new int[len * 2];
        System.arraycopy(code, 0, copy, 0, len);
        System.arraycopy(code, 0, copy, len, len);
        code = copy;

        int l = k > 0 ? 1 : len + k;
        int r = k > 0 ? k : len - 1;

        int w = 0;
        for (int i = l; i <= r; i++) {
            w += code[i];
        }

        for (int i = 0; i < len; i++) {
            res[i] = w;
            w -= code[l];
            w += code[r + 1];
            l++;
            r++;
        }

        return res;
    }
}
