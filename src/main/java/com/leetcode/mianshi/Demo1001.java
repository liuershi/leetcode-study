package com.leetcode.mianshi;

/**
 * @Author milindeyu
 * @Date 2022/8/5 12:41 上午
 * @Version 1.0
 */
public class Demo1001 {

    public void merge(int[] A, int m, int[] B, int n) {
        if (n == 0) return;
        if (m == 0) {
            for (int i = 0; i < B.length; i++) {
                A[i] = B[i];
            }
            return;
        }
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (A[m] == B[n]) {
                A[m + n + 1] = A[m + n] = A[m];
                m--;
                n--;
            } else if (A[m] > B[n]) {
                A[m + n + 1] = A[m];
                m--;
            } else {
                A[m + n + 1] = B[n];
                n--;
            }
        }
    }
}
