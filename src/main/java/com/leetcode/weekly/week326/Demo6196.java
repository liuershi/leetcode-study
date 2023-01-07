package com.leetcode.weekly.week326;

import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2023/1/1 10:50 上午
 * @Version 1.0
 */
public class Demo6196 {

    public int minimumPartition(String s, int k) {
        // 当k小于10时特判是否存在不可能的情况
        if (k < 10) {
            for (char c : s.toCharArray()) {
                if (c - '0' > k)
                    return -1;
            }
            return s.length();
        }

        int res = 0;
        int n = String.valueOf(k).length();
        int i = 0;
        while (i < s.length()) {
            int end = Math.min(s.length(), i + n);
            int val = Integer.parseInt(s.substring(i, end));
            if (k >= val) {
                i += n;
            } else {
                i += n - 1;
            }
            res++;
        }
        return res;

    }
}
