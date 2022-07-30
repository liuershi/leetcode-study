package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/7/30 12:38 上午
 * @Version 1.0
 */
public class Demo455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int rsp = 0;
        int len = Math.min(g.length, s.length);
        for (int i = len - 1, j = s.length - 1; i >= 0 && j >= s.length - len;) {
            if (s[i] >= g[j]) {
                rsp++;
                i--;
                j--;
            } else i--;
        }

        return rsp;
    }
}
