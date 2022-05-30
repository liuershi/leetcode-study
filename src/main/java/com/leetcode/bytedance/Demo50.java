package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/22 4:54 下午
 * @Version 1.0
 */
public class Demo50 {

    public double myPow(double x, int n) {
        long N = n;
//        return N >= 0 ? quickMul(x, n) : 1 / (quickMul(x, -n));

        if (N < 0)
            N = -N;
        double rsp = 1;
        double contribution = x;
        while (N > 0) {
            if (N % 2 == 1) {
                rsp *= contribution;
            }

            contribution *= contribution;
            N = N / 2;
        }
        return n < 0 ? 1 / rsp : rsp;
    }

    /**
     * 基于递归的调用，所有时间和空间复杂度都为 Log(n)
     * @param x
     * @param n
     * @return
     */
    private double quickMul(double x, int n) {
        if (n == 0)
            return 1;
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        Demo50 demo50 = new Demo50();
        System.out.println(demo50.myPow(2, 4));
    }
}
