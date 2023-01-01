package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/12/27 6:20 下午
 * @Version 1.0
 */
public class Demo2027 {

    public int minimumMoves(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'X') {
                i += 2;
                res++;
            }
        }
        return res;
    }
}
