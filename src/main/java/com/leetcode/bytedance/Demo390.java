package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/29 11:36 下午
 * @Version 1.0
 */
public class Demo390 {

    public int lastRemaining(int n) {
        if (n == 1) return n;
        boolean[] arr = new boolean[n];
        int cur = n / 2;
        int s1 = 0, s2 = n - 1;
        while (cur-- > 0) {
            // left
            for (int i = s1; i < n; i += 2) {
                if (arr[i]) continue;
                arr[i] = true;
            }
            // right
            for (int i = s2; i >= 0; i -= 2) {
                if (arr[i]) continue;
                arr[i] = true;
            }
            s1++;
            s2--;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i]) return i + 1;
        }
        return -1;
        // todo 未实现
    }
}
