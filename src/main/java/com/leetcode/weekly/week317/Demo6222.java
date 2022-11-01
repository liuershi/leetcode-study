package com.leetcode.weekly.week317;

/**
 * @Author milindeyu
 * @Date 2022/10/30 11:48 上午
 * @Version 1.0
 */
public class Demo6222 {

    public long makeIntegerBeautiful(long n, int target) {
        // 思路：按位来，从个位开始
        long rsp = 0, increment = 0;
        int divisorCount = String.valueOf(n).length() - 1;
        int loop = 0;
        while (true) {
            if (process(n) <= target)
                break;
            increment = (long) ((10 - (String.valueOf(n).charAt(divisorCount--) - '0')) * Math.pow(10, loop++));
            rsp += increment;
            n += increment;
        }
        return rsp;
    }

    private int process(long n) {
        if (n < 10) return (int) n;
        int sum = 0;
        for (char c : String.valueOf(n).toCharArray()) {
            sum += c - '0';
        }
        return sum;
    }

    public static void main(String[] args) {
        Demo6222 demo6222 = new Demo6222();
        System.out.println(demo6222.makeIntegerBeautiful(467, 6));
        System.out.println(Integer.MAX_VALUE);
    }
}
